package ru.drudenko.ads.cian;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.spi.AdsParser;
import ru.drudenko.ads.api.AdsParserName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CianAdsParser implements AdsParser {

    private final static String URL = "https://spb.cian.ru/cat.php?deal_type=rent&engine_version=2&offer_type=flat&region=2&room1=1&room2=1&type=4&p=";
    private final static int MAX_PAGE = 5;

    @Override
    public List<Ads> parse() {
        List<Ads> result = new ArrayList<>();
        try {
            for (int i = 1; i < MAX_PAGE; i++) {
                Document doc = Jsoup.connect(URL + i).get();
                Elements newsHeadlines = doc.select(".c6e8ba5398--main--332Qx");
                for (Element headline : newsHeadlines) {
                    String title = Optional.ofNullable(headline.children().select(".c6e8ba5398--single_title--22TGT").first())
                            .map(element -> element.childNode(0).attr("#text"))
                            .orElseGet(() -> headline.selectFirst(".c6e8ba5398--subtitle--UTwbQ").text());

                    String ref = headline.children().select(".c6e8ba5398--header--1fV2A").first().absUrl("href");
                    String cost = Optional.ofNullable(headline.children().select(".c6e8ba5398--header--1dF9r").first())
                            .map(element -> element.childNode(0).attr("#text"))
                            .orElse(null);

                    String address = headline.children().select(".c6e8ba5398--address-links--1pHHO").first().children().first().attr("content");
                    result.add(new Ads(title, address, cost, ref));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public AdsParserName getName() {
        return AdsParserName.ofString("ЦИАН");
    }
}
