package avis.ipdetection4j.common.parsers;

import org.json.JSONObject;

public class JSONObjectParser implements ReturnTypeParser<JSONObject> {

    @Override
    public Class<JSONObject> toType() {
        return JSONObject.class;
    }

    @Override
    public ParsingResult parse(ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof JSONObject) {
            delegate.value = value;
            delegate.error = false;
        } else {
            delegate.value = null;
            delegate.error = true;
        }
        return delegate;
    }
}
