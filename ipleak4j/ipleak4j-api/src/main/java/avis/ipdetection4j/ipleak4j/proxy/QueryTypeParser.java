package avis.ipdetection4j.ipleak4j.proxy;

import avis.ipdetection4j.annotations.Parser;

public class QueryTypeParser implements Parser<String, QueryType> {
    @Override
    public QueryType parse(String s) {
        return QueryType.fromString(s);
    }
}
