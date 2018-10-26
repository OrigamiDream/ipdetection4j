package avis.ipqualityscore4j.builders.email;

import avis.ipqualityscore4j.builders.IParameter;
import avis.ipqualityscore4j.builders.Parameter;
import avis.ipqualityscore4j.email.EmailRequest;

public class EmailRequestBuilder implements EmailRequest, IParameter {

    private String email;
    private boolean sync;

    private final Parameter parameter = new Parameter();

    public EmailRequestBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String email() {
        return email;
    }

    public EmailRequestBuilder fast(boolean fast) {
        parameter.put("fast", fast);
        return this;
    }

    @Override
    public boolean fast() {
        return parameter.get("fast");
    }

    public EmailRequestBuilder timeout(int timeout) {
        parameter.put("timeout", timeout);
        return this;
    }

    @Override
    public int timeout() {
        return parameter.get("timeout");
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }
    
    public EmailRequestBuilder sync(boolean sync) {
        this.sync = sync;
        return this;
    }
    
    @Override
    public boolean sync() {
        return sync;
    }
}
