package ru.drudenko.ads.core.rest.impl;

import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.api.AdsParserName;
import ru.drudenko.ads.api.AdsService;
import ru.drudenko.ads.core.rest.AdsParserController;

import java.util.List;

public class AdsParserControllerImpl implements AdsParserController {
    private final AdsService adsService;

    public AdsParserControllerImpl(AdsService adsService) {
        this.adsService = adsService;
    }

    @Override
    public List<Ads> getAds() {
        return adsService.getAllAds();
    }

    @Override
    public List<AdsParserName> getParsers() {
        return adsService.getAdsParsers();
    }
}
