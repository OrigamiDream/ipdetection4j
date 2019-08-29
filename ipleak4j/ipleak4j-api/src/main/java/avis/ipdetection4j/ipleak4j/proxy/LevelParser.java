package avis.ipdetection4j.ipleak4j.proxy;

import avis.ipdetection4j.annotations.Parser;

public class LevelParser implements Parser<String, Level> {
    @Override
    public Level parse(String s) {
        return Level.fromString(s);
    }
}
