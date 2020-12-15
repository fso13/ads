package ru.drudenko.ads.core;

import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.api.AdsParserName;
import ru.drudenko.ads.api.AdsService;
import ru.drudenko.ads.spi.AdsParser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdsServiceImpl implements AdsService {

    private final List<AdsParser> parsers;

    public AdsServiceImpl(List<AdsParser> parsers) {
        this.parsers = parsers;
    }

    @Override
    public List<Ads> getAllAds() {
        return parsers.stream()
                .map(AdsParser::parse)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsParserName> getAdsParsers() {
        return parsers.stream()
                .map(AdsParser::getName)
                .collect(Collectors.toList());
    }
}
