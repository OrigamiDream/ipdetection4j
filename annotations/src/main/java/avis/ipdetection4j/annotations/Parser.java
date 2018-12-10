package avis.ipdetection4j.annotations;

public interface Parser<T, R> {

    R parse(T t);

}
