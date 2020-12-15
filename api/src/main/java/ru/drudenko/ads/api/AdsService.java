package ru.drudenko.ads.api;

import java.util.List;

public interface AdsService {
    List<Ads> getAllAds();

    List<AdsParserName> getAdsParsers();
}
