package avis.ipqualityscore4j.common.parsers;

import avis.ipqualityscore4j.annotations.Generic;
import org.json.JSONArray;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListParser implements ReturnTypeParser<List> {

    @Override
    public Class<List> toType() {
        return List.class;
    }

    @Override
    public ParsingResult parse(Class returnType, Method method, ParsingResult delegate, Object value) {
        if(value == null) {
            delegate.value = null;
            delegate.error = false;
            return delegate;
        }
        Generic generic = method.getAnnotation(Generic.class);
        if(generic.value().length != 1) {
            throw new IllegalArgumentException("Generic count have to be one. Method: " + method.getName() + "()");
        }
        Class<?> attribute = generic.value()[0];
        if(value instanceof List) {
            delegate.value = ((List<?>) value)
                    .stream()
                    .map(o -> ReturnTypeParser.parseReturnType(attribute, method, o))
                    .collect(Collectors.toList());

            delegate.error = false;
        } else {
            if(value instanceof JSONArray) {
                JSONArray array = (JSONArray) value;
                delegate.value = IntStream.range(0, array.length())
                        .mapToObj(i -> array.get(i))
                        .map(o -> ReturnTypeParser.parseReturnType(attribute, method, o))
                        .collect(Collectors.toList());
                delegate.error = false;
            } else {
                delegate.value = null;
                delegate.error = true;
            }
        }
        return delegate;
    }
}
