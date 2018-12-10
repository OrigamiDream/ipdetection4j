package avis.ipdetection4j.common.parsers;

public class DoubleParser implements ReturnTypeParser<Double> {

    @Override
    public Class[] toTypes() {
        return new Class[] { double.class, Double.class };
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = returnType.isPrimitive() ? 0d : null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof Double) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = Double.parseDouble(value.toString());
                delegate.error = false;
            } catch (NumberFormatException e) {
                delegate.value = returnType.isPrimitive() ? 0d : null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
