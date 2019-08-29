package avis.ipdetection4j.ipleak4j.proxy;

public enum Level {

    MIN,
    MAX;

    public static Level fromString(String string) {
        try {
            return Level.valueOf(string.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("String level '" + string + "' is invalid.");
        }
    }

}
