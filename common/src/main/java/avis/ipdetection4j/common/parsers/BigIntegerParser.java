package avis.ipdetection4j.common.parsers;

import java.math.BigInteger;

public class BigIntegerParser implements ReturnTypeParser<BigInteger> {

    @Override
    public Class<BigInteger> toType() {
        return BigInteger.class;
    }

    @Override
    public ParsingResult parse(ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof BigInteger) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = new BigInteger(value.toString());
                delegate.error = false;
            } catch (Exception e) {
                delegate.value = null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
