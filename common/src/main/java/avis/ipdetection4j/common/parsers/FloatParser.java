package avis.ipdetection4j.common.parsers;

public class FloatParser implements ReturnTypeParser<Float> {

    @Override
    public Class[] toTypes() {
        return new Class[] { float.class, Float.class };
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = returnType.isPrimitive() ? 0f : null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof Float) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = Float.parseFloat(value.toString());
                delegate.error = false;
            } catch (NumberFormatException e) {
                delegate.value = returnType.isPrimitive() ? 0f : null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
