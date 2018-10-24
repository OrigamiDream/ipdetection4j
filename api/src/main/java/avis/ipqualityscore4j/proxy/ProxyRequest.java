package avis.ipqualityscore4j.proxy;

import avis.ipqualityscore4j.components.Request;

public interface ProxyRequest extends Request {

    // =================
    // == RESTful API ==
    // =================

    String ipAddress();

    // =================
    // === Parameter ===
    // =================

    /**
     *
     * How in depth (strict) do you want this query to be?
     * Higher values take longer to process and may provide higher false-positive rate.
     *
     * We recommend starting at "0", the lowest strictness setting,
     * and increasing to "1" or "2" depending on your levels of fraud.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Integer}
     */
    int strictness();

    /**
     *
     * You can optionally provide us with the user agent string (browser).
     *
     * This allows us to run additional checks to see
     * if the user is a bot or running an invalid browser.
     *
     * This allows us to evaluate the risk of the user as judged in the "fruad_score".
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String userAgent();

    /**
     *
     * You can optionally provide us with the user's language header.
     * This allows us to evaluate the risk of the user as judged in the "fruad_score".
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String userLanguage();

    /**
     *
     * When this parameter is enabled our API will not perform certain
     * forensic checks that take longer to process.
     *
     * Enabling this feature greatly increases the API speed without much impact on accuracy.
     *
     * This option is intended for services that require decision
     * making in a time sensitive manner and can be used for any strictness level.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean fast();

    /**
     *
     * You can optionally specify that this lookup should be
     * treated as a mobile device.
     *
     * Recommended for mobile lookups that do not have a user agent
     * attached to the request.
     *
     * NOTE:
     * This can cause unexpected and abnormal results if the
     * device is not a mobile device.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean mobile();

    /**
     *
     * Bypasses certain checks for IP addresses from education and research institutions,
     * schools, and some corporate connections to better accommodate audiences
     * that fequently use public connections.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean allowPublicAccessPoints();

    /**
     * Adjusts the weights for penalties applied due to irregularities and fraudulent patterns
     * detected on order and transaction details that can be optionally provided on each API request.
     * This feature is only beneficial if you are passing order and transaction details.
     * A table is available further down the page with supported transaction variables.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Integer}
     */
    int transactionStrictness();

}
