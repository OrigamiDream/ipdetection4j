package avis.ipqualityscore4j.common.parsers;

public class LongParser implements ReturnTypeParser<Long> {

    @Override
    public Class[] toTypes() {
        return new Class[] { long.class, Long.class };
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = returnType.isPrimitive() ? 0 : null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof Long) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = Long.parseLong(value.toString());
                delegate.error = false;
            } catch (NumberFormatException e) {
                delegate.value = returnType.isPrimitive() ? 0 : null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
