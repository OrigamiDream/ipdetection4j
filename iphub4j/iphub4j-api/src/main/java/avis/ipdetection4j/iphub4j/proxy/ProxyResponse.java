package avis.ipdetection4j.iphub4j.proxy;

import avis.ipdetection4j.annotations.Fixed;
import avis.ipdetection4j.annotations.MethodParser;
import avis.ipdetection4j.common.Response;

public interface ProxyResponse extends Response {

    String ip();

    @Fixed String countryCode();

    @Fixed String countryName();

    String asn();

    String isp();

    @MethodParser(value = BlockParser.class, returnType = Integer.class) Block block();

    String hostname();

}
