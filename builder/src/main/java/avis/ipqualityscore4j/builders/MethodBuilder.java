package avis.ipqualityscore4j.builders;

import avis.ipqualityscore4j.annotations.Parameter;
import avis.ipqualityscore4j.common.ILambdaHelper;
import avis.ipqualityscore4j.common.LowcaseBuilder;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public interface MethodBuilder extends ILambdaHelper, LowcaseBuilder {

    default String buildByMethod(Object o) {
        return Arrays.stream(o.getClass().getDeclaredMethods())
                .filter(method -> method.getAnnotation(Parameter.class) != null)
                .map(rethrow((Method method) -> {
                    Object value = method.invoke(o);
                    if(value == null || (value instanceof String && ((String) value).length() == 0)) {
                        return "";
                    }
                    return makeLowcase(method.getName()) + "=" + value;
                }))
                .filter(value -> value.length() > 0)
                .collect(Collectors.joining("&"));
    }

}
