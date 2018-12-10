package avis.ipdetection4j.common.parsers;

public class StringParser implements ReturnTypeParser<String> {

    @Override
    public Class<String> toType() {
        return String.class;
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof String) {
            delegate.value = value;
            delegate.error = false;
        } else {
            delegate.value = value.toString();
            delegate.error = true;
        }
        return delegate;
    }
}
