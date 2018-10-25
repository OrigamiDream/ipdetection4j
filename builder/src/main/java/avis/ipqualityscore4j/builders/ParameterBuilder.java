package avis.ipqualityscore4j.builders;

import java.util.concurrent.atomic.AtomicInteger;

public interface ParameterBuilder {

    default String buildByParameter(Object o) {
        if(!(o instanceof IParameter)) {
            throw new IllegalArgumentException("Object '" + o.getClass().getSimpleName() + "' does not implement IParameter");
        }
        return buildByParameter((IParameter) o);
    }

    default String buildByParameter(IParameter parameter) {
        return buildByParameter(parameter.getParameter());
    }

    default String buildByParameter(Parameter parameter) {
        StringBuilder builder = new StringBuilder();
        int len = parameter.getParameters().size();
        AtomicInteger i = new AtomicInteger(0);
        parameter.getParameters().forEach((key, value) -> {
            builder.append(key).append("=").append(value.toString());
            if(i.incrementAndGet() != len) {
                builder.append("&");
            }
        });
        return builder.toString();
    }

}
