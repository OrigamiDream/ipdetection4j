package avis.ipdetection4j.getipintel4j.proxy;

import avis.ipdetection4j.annotations.Parser;

public class StatusParser implements Parser<String, Status> {
    @Override
    public Status parse(String s) {
        return Status.getByStatus(s);
    }
}
