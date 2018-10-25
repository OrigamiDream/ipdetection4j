package avis.ipqualityscore4j.email;

import avis.ipqualityscore4j.annotations.Parser;

public class SmtpScoreParser implements Parser<String, SmtpScore> {
    @Override
    public SmtpScore parse(String integer) {
        return SmtpScore.getByScore(Integer.parseInt(integer));
    }
}
