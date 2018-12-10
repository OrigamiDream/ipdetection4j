package avis.ipdetection4j.ipqualityscore4j.email;

public enum SmtpScore {

    INVALID_EMAIL_ADDRESS(-1),
    REJECTING_ALL_MAIL(0),
    TEMPORARY_ERROR(1),
    ACCEPTS_ALL_MAIL(2),
    VERIFIED_EMAIL_ADDRESS(3);

    private final int score;

    SmtpScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static SmtpScore getByScore(int score) {
        for(SmtpScore smtpScore : values()) {
            if(smtpScore.getScore() == score) {
                return smtpScore;
            }
        }
        throw new IllegalArgumentException("Not declared score by API: '" + score + "'");
    }
}
