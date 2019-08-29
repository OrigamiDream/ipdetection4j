package avis.ipdetection4j.ipleak4j.proxy;

public enum QueryType {

    MY_IP("myip"),
    MY_DNS("mydns"),
    IP("ip"),
    DOMAIN("domain");

    private final String id;

    QueryType(String id) {
        this.id = id;
    }

    public static QueryType fromString(String string) {
        for(QueryType queryType : QueryType.values()) {
            if(queryType.id.equals(string)) {
                return queryType;
            }
        }
        throw new IllegalArgumentException("Query type '" + string + "' is invalid.");
    }
}
