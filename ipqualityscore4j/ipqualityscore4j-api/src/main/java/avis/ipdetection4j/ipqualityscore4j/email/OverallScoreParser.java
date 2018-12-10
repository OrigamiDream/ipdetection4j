package avis.ipdetection4j.ipqualityscore4j.email;

import avis.ipdetection4j.annotations.Parser;

public class OverallScoreParser implements Parser<Integer, OverallScore> {
    @Override
    public OverallScore parse(Integer integer) {
        return OverallScore.getByScore(integer);
    }
}
