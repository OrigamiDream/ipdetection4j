package avis.ipdetection4j.getipintel4j.builders.proxy;

import avis.ipdetection4j.builders.IParameter;
import avis.ipdetection4j.builders.Parameter;
import avis.ipdetection4j.getipintel4j.components.Flags;
import avis.ipdetection4j.getipintel4j.components.OFlags;
import avis.ipdetection4j.getipintel4j.proxy.ProxyRequest;

public class ProxyRequestBuilder implements ProxyRequest, IParameter {

    private boolean sync;

    private final Parameter parameter = new Parameter();

    @Override
    public Parameter getParameter() {
        return parameter;
    }

    @Override
    public String ip() {
        return parameter.get("ip");
    }

    public ProxyRequestBuilder ip(String ip) {
        parameter.put("ip", ip);
        return this;
    }

    @Override
    public String contact() {
        return parameter.get("contact");
    }

    public ProxyRequestBuilder contact(String contact) {
        parameter.put("contact", contact);
        return this;
    }

    @Override
    public String flags() {
        return parameter.get("flags");
    }

    public ProxyRequestBuilder flags(Flags flags) {
        parameter.put("flags", flags.toString().toLowerCase());
        return this;
    }

    @Override
    public String oFlags() {
        return parameter.get("oflags");
    }

    public ProxyRequestBuilder oFlags(OFlags oFlags) {
        parameter.put("oflags", oFlags.toString().toLowerCase());
        return this;
    }

    @Override
    public boolean sync() {
        return sync;
    }

    public ProxyRequestBuilder sync(boolean sync) {
        this.sync = sync;
        return this;
    }
}
