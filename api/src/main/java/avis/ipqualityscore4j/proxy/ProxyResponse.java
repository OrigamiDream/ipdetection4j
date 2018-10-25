package avis.ipqualityscore4j.proxy;

import avis.ipqualityscore4j.annotations.Uppercase;
import avis.ipqualityscore4j.components.Response;

public interface ProxyResponse extends Response {

    /**
     *
     * Is this IP address suspected to be a proxy? (SOCKS, Elite, Anonymous, VPN, Tor, etc.)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean proxy();

    /**
     *
     * Hostname of the IP address if one is available.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String host();

    /**
     *
     * ISP if one is known. Otherwise "N/A".
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    @Uppercase String isp();

    /**
     *
     * Organization if one is known.
     *
     * Can be parent company or sub company of the listed ISP.
     *
     * Otherwise "N/A".
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String organization();

    /**
     *
     * Autonomous System Number if one is known.
     *
     * Otherwise "N/A".
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    @Uppercase String asn();

    /**
     *
     * Two character country code of IP address or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String countryCode();

    /**
     *
     * City of IP address if available or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String city();

    /**
     *
     * Region (state) of IP address if available or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String region();

    /**
     *
     * Timezone of IP addres if available or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String timezone();

    /**
     *
     * Latitude of IP address if available or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    int latitude();

    /**
     *
     * "Longitude of IP address if available or "N/A" if unknown.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String longitude();

    /**
     *
     * Is this IP is associated with being a confirmed crawler such as GOoglebot, Bingbot, etc
     * base on hostname or IP address verification.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean isCrawler();

    /**
     *
     * This value will indicate if there has been any recently verified abuse across our network
     * for this IP address.
     *
     * Abuse coulkd be a confirmed chargeback, compromised device, fake app install,
     *or similar malicious behavior within the past few days.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean recentAbuse();

    /**
     *
     * Is this IP suspectd of being a VPN connection? (Proxy will always be true if this is true)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean vpn();

    /**
     *
     * Is thi IP suspected of being a Tor connection? (Proxy will always be true if this is true)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean tor();

    /**
     *
     * Is this user agent a mobile browser? (will always be false if the user agent is not passed in the API request)
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Boolean}
     */
    boolean mobile();

    /**
     *
     * The overall fraud score of the user based on the IP, user agent, language, and any other
     * optionally passed variables.
     *
     * We recommend that any fraud score equal to or over 75 be treated as a risky user.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Float}
     */
    float fraudScore();

    /**
     *
     * Operating system name and version or "N/A" if unknown. Requires the "user_agent" variable in the API Request.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String operatingSystem();

    /**
     *
     * Browser name and version or "N/A" if unknown.
     *
     * Requires the "user_agent" variable in the API Request.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String browser();

    /**
     *
     * Brand name of the device or "N/A" if unknown. Requires the "user_agent" variable in the API Request.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String deviceBrand();

    /**
     *
     * Model name ofo the device or "N/A" if unknown.
     *
     * Requires the "user_agent" variable in the API Request.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link String}
     */
    String deviceModel();

    /**
     *
     * Additional scoring variables for risk analysis only available when transaction data
     * is passed through the API request.
     *
     * These variables are also useful for scoring physical address data
     * pased along with the API request.
     *
     * @apiNote Fetched from https://www.ipqualityscore.com/user/proxy-detection-api/documentation
     * @return {@link Object}
     */
    Object transactionDetails();

}
