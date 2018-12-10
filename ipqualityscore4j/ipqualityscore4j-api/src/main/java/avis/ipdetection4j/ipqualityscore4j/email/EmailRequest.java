package avis.ipdetection4j.ipqualityscore4j.email;

import avis.ipdetection4j.annotations.Parameter;
import avis.ipdetection4j.annotations.RESTful;
import avis.ipdetection4j.ipqualityscore4j.components.IpQualityScoreRequest;

public interface EmailRequest extends IpQualityScoreRequest {

    // =================
    // == RESTful API ==
    // =================

    @RESTful String email();

    // =================
    // === Parameter ===
    // =================

    /**
     *
     * When this parameter is enabled our API will not perform an SMTP check
     * with the mail service provider, which greatly increases the API speed.
     *
     * Syntax and DNS checks are still performed on the email address as well as
     * our disposable email detection service.
     *
     * This option is intended for services that require decision
     * making in a time sensitive manner.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Boolean}
     */
    @Parameter boolean fast();

    /**
     *
     * Maximum number of seconds to wait for a reply from a mail service provider.
     * If your implementation requirements do not need an immediate response,
     * we recommend bumping this value to 20.
     *
     * Any results which experience a connection timeout will return
     * the "timed_out" variable as true.
     *
     * Default value is 7 seconds.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/email-verification-api/documentation
     * @return {@link Integer}
     */
    @Parameter int timeout();

}
