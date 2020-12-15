package ru.drudenko.ads.avito;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.api.AdsParserName;
import ru.drudenko.ads.spi.AdsParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvitoAdsParser implements AdsParser {

    private final static String URL = "https://www.avito.ru/sankt-peterburg/kvartiry/sdam?&p=";
    private final static int MAX_PAGE = 5;

    @Override
    public List<Ads> parse() {


        List<Ads> result = new ArrayList<>();
        try {
            for (int i = 1; i < MAX_PAGE; i++) {
                Document doc = Jsoup.connect(URL + i).get();

                Elements newsHeadlines = doc.select(".item_table-wrapper");
                for (Element headline : newsHeadlines) {
                    String title = headline.selectFirst(".item-description-title-link").attr("title");
                    String ref = headline.selectFirst(".item-description-title-link").absUrl("href");
                    String address = headline.selectFirst(".address").textNodes().stream().map(TextNode::text).collect(Collectors.joining());
                    String cost = headline.selectFirst(".about").children().stream().map(element -> element.attr("content")).collect(Collectors.joining());
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
        return AdsParserName.ofString("AVITO");
    }
}
