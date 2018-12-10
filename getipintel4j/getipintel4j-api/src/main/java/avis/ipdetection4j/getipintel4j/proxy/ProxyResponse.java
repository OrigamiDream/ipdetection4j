package avis.ipdetection4j.getipintel4j.proxy;

import avis.ipdetection4j.annotations.Fixed;
import avis.ipdetection4j.annotations.MethodParser;
import avis.ipdetection4j.common.Response;

public interface ProxyResponse extends Response {

    @MethodParser(value = StatusParser.class, returnType = String.class) Status status();

    double result();

    String message();

    @Fixed String queryIP();

    @Fixed String queryFlags();

    @Fixed String queryOFlags();

    @Fixed String queryFormat();

    String contact();

}
