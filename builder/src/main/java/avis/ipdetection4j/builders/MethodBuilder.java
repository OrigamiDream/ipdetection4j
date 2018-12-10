package avis.ipdetection4j.builders;

import avis.ipdetection4j.annotations.Parameter;
import avis.ipdetection4j.common.ILambdaHelper;
import avis.ipdetection4j.common.LowcaseBuilder;

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
                    Parameter parameter = method.getAnnotation(Parameter.class);
                    String key;
                    if(!parameter.value().isEmpty()) {
                        key = parameter.value();
                    } else {
                        key = makeLowcase(method.getName());
                    }
                    return key + "=" + value;
                }))
                .filter(value -> value.length() > 0)
                .collect(Collectors.joining("&"));
    }

}
