package ru.drudenko.ads.core.rest;

import ru.drudenko.ads.api.Ads;
import ru.drudenko.ads.api.AdsParserName;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface AdsParserController {
    @GET
    @Path("/ads")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<Ads> getAds();

    @GET
    @Path("/parsers")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<AdsParserName> getParsers();
}
