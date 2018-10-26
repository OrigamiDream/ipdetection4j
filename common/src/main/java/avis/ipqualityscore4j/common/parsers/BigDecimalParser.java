package avis.ipqualityscore4j.common.parsers;

import java.math.BigDecimal;

public class BigDecimalParser implements ReturnTypeParser<BigDecimal> {

    @Override
    public Class<BigDecimal> toType() {
        return BigDecimal.class;
    }

    @Override
    public ParsingResult parse(ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        if(value instanceof BigDecimal) {
            delegate.value = value;
            delegate.error = false;
        } else {
            try {
                delegate.value = new BigDecimal(value.toString());
                delegate.error = false;
            } catch (Exception e) {
                delegate.value = null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
