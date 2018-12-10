package avis.ipdetection4j.ipqualityscore4j.email;

import avis.ipdetection4j.annotations.Parser;

public class SmtpScoreParser implements Parser<Integer, SmtpScore> {
    @Override
    public SmtpScore parse(Integer integer) {
        return SmtpScore.getByScore(integer);
    }
}
