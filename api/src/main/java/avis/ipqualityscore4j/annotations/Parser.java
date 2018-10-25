package avis.ipqualityscore4j.annotations;

public interface Parser<T, R> {

    R parse(T t);

}
