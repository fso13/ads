package ru.drudenko.ads.spi;

import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.api.AdsParserName;

import java.util.List;

public interface AdsParser {
    List<Ads> parse();

    AdsParserName getName();
}
