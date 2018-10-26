package avis.ipqualityscore4j.common.parsers;

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

    public static void main(String args[]) {
        IntegerParser parser = new IntegerParser();
        ParsingResult result = parser.parse(Integer.class, new ParsingResult(), "1.262");

        System.out.println("error: " + result.error);
        System.out.println("value: " + result.value);
    }
}
