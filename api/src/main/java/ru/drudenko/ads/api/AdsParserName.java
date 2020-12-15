package ru.drudenko.ads.api;

public class AdsParserName {
    private final String name;

    private AdsParserName(String name) {
        this.name = name;
    }

    public static AdsParserName ofString(String s) {
        return new AdsParserName(s);
    }

    public String getName() {
        return name;
    }
}
