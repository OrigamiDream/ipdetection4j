package avis.ipqualityscore4j.email;

import avis.ipqualityscore4j.annotations.Parser;

public class OverallScoreParser implements Parser<Integer, OverallScore> {
    @Override
    public OverallScore parse(Integer integer) {
        return OverallScore.getByScore(integer);
    }
}
