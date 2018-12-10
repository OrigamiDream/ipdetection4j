package avis.ipdetection4j.common.parsers;

import avis.ipdetection4j.annotations.MethodParser;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static avis.ipdetection4j.common.parsers.ReturnTypeParser.Parser.PARSERS;

public interface ReturnTypeParser<T> {

    default Class<T> toType() {
        return null;
    }

    default Class[] toTypes() {
        return new Class[] { toType() };
    }

    default ParsingResult parse(ParsingResult delegate, Object value) {
        return null;
    }

    default ParsingResult parse(Class returnType, ParsingResult delegate, Object value) {
        return parse(delegate, value);
    }

    default ParsingResult parse(Class returnType, Method method, ParsingResult delegate, Object value) {
        return parse(returnType, delegate, value);
    }

    public static Object parseReturnType(Class returnType, Method method, Object value) {
        MethodParser methodParser = method.getAnnotation(MethodParser.class);
        if(methodParser != null) {
            returnType = methodParser.returnType();
        }

        ParsingResult delegate = new ParsingResult();
        boolean start = false;
        Class<? extends ReturnTypeParser> redirectTo = null;
        for(ReturnTypeParser parser : PARSERS) {
            if(redirectTo != null && redirectTo != parser.getClass()) {
                continue;
            }
            if(redirectTo != null) {
                delegate.redirectTo = null;
                redirectTo = null;
            }
            for(Class type : parser.toTypes()) {
                if(returnType == type) {
                    start = true;
                    break;
                }
            }

            if(start) {
                delegate = parser.parse(returnType, method, delegate, value);
            }
            if(delegate.error) {
                if(delegate.redirectTo != null) {
                    redirectTo = delegate.redirectTo;
                }
            } else {
                break;
            }
        }
        if(!start) {
            delegate.value = value;
        }
        return delegate.value;
    }

    public static Object parseReturnType(Class returnType, Method method, String key, JSONObject data) {
        return parseReturnType(returnType, method, data.has(key) ? data.get(key) : null);
    }

    public static class Parser {

        public static final List<ReturnTypeParser> PARSERS = new ArrayList<>();
        static {
            PARSERS.add(new ListParser());
            PARSERS.add(new JSONArrayParser());
            PARSERS.add(new JSONObjectParser());
            PARSERS.add(new BigIntegerParser());
            PARSERS.add(new BigDecimalParser());
            PARSERS.add(new BooleanParser());
            PARSERS.add(new IntegerParser());
            PARSERS.add(new LongParser());
            PARSERS.add(new FloatParser());
            PARSERS.add(new DoubleParser());
            PARSERS.add(new StringParser());
        }
    }
}
