package avis.ipdetection4j.common.parsers;

import org.json.JSONArray;

public class JSONArrayParser implements ReturnTypeParser<JSONArray> {

    @Override
    public Class<JSONArray> toType() {
        return JSONArray.class;
    }

    @Override
    public ParsingResult parse(ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof JSONArray) {
            delegate.value = value;
            delegate.error = false;
        } else {
            delegate.value = null;
            delegate.error = true;
        }
        return delegate;
    }
}
