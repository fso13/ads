###### ads-features

karaf 4.2.x
```
repo-add cxf
feature:repo-add mvn:ru.drudenko.ads/ads-api/1.0.1/xml/features
feature:repo-add mvn:ru.drudenko.ads/ads-spi/1.0.1/xml/features
feature:repo-add mvn:ru.drudenko.ads/ads-core/1.0.1/xml/features
feature:repo-add mvn:ru.drudenko.ads/ads-avito-spi/1.0.1/xml/features
feature:repo-add mvn:ru.drudenko.ads/ads-cian-spi/1.0.1/xml/features
feature:repo-add mvn:ru.drudenko.ads/ads-rest-core/1.0.1/xml/features

feature:install http cxf-http http-whiteboard cxf-jaxrs cxf-http-client spring spring-aspects spring-web blueprint-web
feature:install ads-core ads-avito-spi ads-rest-core


