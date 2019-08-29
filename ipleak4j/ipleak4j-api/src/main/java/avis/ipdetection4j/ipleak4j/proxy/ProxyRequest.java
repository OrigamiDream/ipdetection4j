package avis.ipdetection4j.ipleak4j.proxy;

import avis.ipdetection4j.annotations.RESTful;
import avis.ipdetection4j.common.Request;

public interface ProxyRequest extends Request {

    // =================
    // == RESTful API ==
    // =================

    @RESTful
    String ip();

}
