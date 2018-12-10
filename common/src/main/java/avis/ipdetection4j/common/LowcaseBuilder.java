package avis.ipdetection4j.common;

public interface LowcaseBuilder {

    default String makeLowcase(String text) {
        StringBuilder builder = new StringBuilder();
        char c;
        int len = text.length();
        for(int i = 0; i < len; i++) {
            c = text.charAt(i);
            if(Character.isUpperCase(c)) {
                builder.append("_").append(Character.toLowerCase(c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
