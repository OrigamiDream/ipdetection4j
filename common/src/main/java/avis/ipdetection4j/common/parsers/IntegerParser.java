package avis.ipdetection4j.common.parsers;

public class IntegerParser implements ReturnTypeParser<Integer> {

    @Override
    public Class[] toTypes() {
        return new Class[] { int.class, Integer.class };
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = returnType.isPrimitive() ? 0 : null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof Integer) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = Integer.parseInt(value.toString());
                delegate.error = false;
            } catch (NumberFormatException e) {
                delegate.value = returnType.isPrimitive() ? 0 : null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
