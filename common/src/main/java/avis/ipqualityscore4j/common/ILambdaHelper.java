package avis.ipqualityscore4j.common;

import java.util.function.Function;

public interface ILambdaHelper {

    @FunctionalInterface
    interface EFunction<T, R> {

        R apply(T t) throws Exception;

    }

    default <T, R> Function<T, R> rethrow(EFunction<T, R> function) {
        return (t) -> {
            try {
                function.apply(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        };
    }

}
