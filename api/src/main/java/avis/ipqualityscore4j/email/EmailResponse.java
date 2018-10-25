package avis.ipqualityscore4j.email;

import avis.ipqualityscore4j.annotations.MethodParser;
import avis.ipqualityscore4j.components.Response;

public interface EmailResponse extends Response {

    /**
     * Does this email address appear valid?
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean valid();

    /**
     *
     * Is this email suspected of belonging to a temporary or disposable mail service?
     * Usually associated with fraudsters and scammers.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean disposable();

    /**
     *
     * Did the connection to the mail service provider timeout during the verification?
     * If so, we recommend increasing the "timeout" variable above the default 7 second value.
     *
     * Lookups that timeout with a "valid" result as 'false' are most likely false-positives
     * and should be not be trusted.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean timedOut();

    /**
     *
     * How likely is this email to be delivered to the user and land in their mailbox.
     * Values can be "high", "medium", or "low"
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Deliverability}
     */
    @MethodParser(DeliverabilityParser.class) Deliverability deliverability();

    /**
     *
     * Is this email likely to be a "catch all" where the mail server
     * verified all emails tested against it is valid?
     *
     * If this value is true, then we suspect the "valid" result may
     * be tainted and there is not guarantee that the email address is truly valid.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link String}
     */
    boolean suspect();

    /**
     *
     * Validity score of email server's SMTP setup.
     *
     * Range: "-1" - "3".
     *
     * Scores above "-1" can be associated with a valid email.
     *
     * -1 = invalid email address
     * 0 = mail server exists, but is rejecting all mail
     * 1 = mail server exists, but is showing a temporary error
     * 2 = mail server exists, but accepts all email
     * 3 = mail server exists and has verified the email address
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link SmtpScore}
     */
    @MethodParser(SmtpScoreParser.class) SmtpScore smtpScore();

    /**
     *
     * Overall email validity score.
     *
     * Range: "0" - "4".
     *
     * Scores above "1" can be associated with a valid email.
     *
     * 0 - invalid email address
     * 1 = dns valid, unreachable mail server
     * 2 = dns valid, temporary mail rejection error
     * 3 = dns valid, accepts all mail
     * 4 = dns valid, verified email exists
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link OverallScore}
     */
    @MethodParser(OverallScoreParser.class) OverallScore overallScore();

    /**
     *
     * Suspected first name based on email.
     *
     * Returns "CORPORATE" if the email is suspected of being a generic company email.
     *
     * Returns "UNKNOWN" if the first name was not determinable.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link String}
     */
    String firstName();

    /**
     *
     * Is this email from a common email provider?
     * ("gmail.com", "yahoo.com", "hotmail.com", etc.)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean common();

    /**
     *
     * Is this email suspected as being a catch all or shared email for a domain?
     * ("admin@", "webmaster@", "newsletter@", "sales@", "contact@", etc.)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean generic();

    /**
     *
     * Does the email's hostname have valid DNS entries?
     * Partial indication of a valid email.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean dnsValid();

    /**
     *
     * Is this email believed to be a "honeypot" or "SPAM trap"?
     * Bulk mail sent to these emails increases your risk of being blacklisted
     * by large ISPs & ending up in the spam folder.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean honeypot();

    /**
     *
     * This value will indicate if there has been any recently verified abuse
     * across our network for this email address.
     *
     * Abuse could be a confirmed chargeback, fake signup, compromised device,
     * fake app install, or similar malicious behavior within the past few days.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean recentAbuse();

    /**
     *
     * Indicates if this email frequently unsubscribes from marketing lists or reports email as SPAM.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    boolean frequentComplainer();

}
