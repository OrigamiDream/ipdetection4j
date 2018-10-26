package avis.ipqualityscore4j.email;

public enum OverallScore {

    INVALID_EMAIL(-1),
    INVALID_EMAIL_ADDRESS(0),
    UNREACHABLE_MAIL_SERVER(1),
    TEMPORARY_REJECTION(2),
    ACCEPTS_ALL_MAIL(3),
    VERIFIED_EMAIL_EXISTS(4);

    private final int score;

    OverallScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static OverallScore getByScore(int score) {
        for(OverallScore overallScore : values()) {
            if(overallScore.getScore() == score) {
                return overallScore;
            }
        }
        throw new IllegalArgumentException("Not declared score by API: '" + score + "'");
    }
}
