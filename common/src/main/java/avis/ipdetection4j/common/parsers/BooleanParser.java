package avis.ipdetection4j.common.parsers;

public class BooleanParser implements ReturnTypeParser<Boolean> {

    @Override
    public Class<Boolean> toType() {
        return Boolean.class;
    }

    @Override
    public Class[] toTypes() {
        return new Class[] { boolean.class, Boolean.class };
    }

    @Override
    public ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = returnType.isPrimitive() ? false : null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof Boolean) {
            delegate.value = value;
            delegate.error = false;
        } else {
            switch(value.toString()) {
                case "true":
                case "TRUE":
                    delegate.value = true;
                    delegate.error = false;
                    break;

                case "false":
                case "FALSE":
                    delegate.value = false;
                    delegate.error = false;
                    break;

                default:
                    delegate.value = returnType.isPrimitive() ? false : null;
                    delegate.error = true;
                    break;
            }
        }
        return delegate;
    }
}
