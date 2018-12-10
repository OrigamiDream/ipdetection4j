package avis.ipdetection4j.getipintel4j.proxy;

public enum Status {

    SUCCESS,
    ERROR;

    public static Status getByStatus(String message) {
        for(Status status : values()) {
            if(status.toString().equalsIgnoreCase(message)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Not declared id by API: '" + message + "'");
    }

}
