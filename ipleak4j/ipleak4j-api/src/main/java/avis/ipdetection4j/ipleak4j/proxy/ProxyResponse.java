package avis.ipdetection4j.ipleak4j.proxy;

import avis.ipdetection4j.annotations.MethodParser;
import avis.ipdetection4j.common.Response;

public interface ProxyResponse extends Response {

    String countryCode();

    String countryName();

    String regionCode();

    String regionName();

    String cityName();

    String latitude();

    String longitude();

    String metroCode();

    String areaCode();

    String timeZone();

    String continentCode();

    String postalCode();

    String ispName();

    String organizationName();

    String asNumber();

    String netspeed();

    String userType();

    Integer accuracyRadius();

    String countryConfidence();

    String cityConfidence();

    String regionConfidence();

    String postalConfidence();

    @MethodParser(value = LevelParser.class, returnType = String.class) Level level();

    Long cache();

    String continentName();

    String ip();

    String type();

    String reverse();

    String tor();

    String queryText();

    @MethodParser(value = QueryTypeParser.class, returnType = String.class) QueryType queryType();

    long queryDate();

}
