package avis.ipqualityscore4j.internal.response;

import avis.ipqualityscore4j.email.Deliverability;
import avis.ipqualityscore4j.email.EmailResponse;
import avis.ipqualityscore4j.email.OverallScore;
import avis.ipqualityscore4j.email.SmtpScore;

import java.util.List;

public class InternalEmailResponse implements EmailResponse {

    @Override
    public String message() {
        return null;
    }

    @Override
    public boolean success() {
        return false;
    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public boolean disposable() {
        return false;
    }

    @Override
    public boolean timedOut() {
        return false;
    }

    @Override
    public Deliverability deliverability() {
        return null;
    }

    @Override
    public String suspect() {
        return null;
    }

    @Override
    public SmtpScore smtpScore() {
        return null;
    }

    @Override
    public OverallScore overallScore() {
        return null;
    }

    @Override
    public String firstName() {
        return null;
    }

    @Override
    public boolean common() {
        return false;
    }

    @Override
    public boolean generic() {
        return false;
    }

    @Override
    public boolean dnsValid() {
        return false;
    }

    @Override
    public boolean honeypot() {
        return false;
    }

    @Override
    public boolean recentAbuse() {
        return false;
    }

    @Override
    public boolean frequentComplainer() {
        return false;
    }

    @Override
    public String requestId() {
        return null;
    }

    @Override
    public List<String> errors() {
        return null;
    }
}
