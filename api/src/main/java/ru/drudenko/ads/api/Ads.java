package ru.drudenko.ads.api;

public class Ads {

    private final String title;
    private final String address;
    private final String cost;
    private final String ref;

    public Ads(String title, String address, String cost, String ref) {
        this.title = title;
        this.address = address;
        this.cost = cost;
        this.ref = ref;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }

    public String getRef() {
        return ref;
    }

    public String getAddress() {
        return address;
    }
}
