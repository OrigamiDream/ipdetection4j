package avis.ipdetection4j.getipintel4j.proxy;

import avis.ipdetection4j.annotations.Parameter;
import avis.ipdetection4j.common.Request;

public interface ProxyRequest extends Request {

    @Parameter String ip();

    @Parameter String contact();

    /**
     * 'flags=m' is used when you're only looking for the value of "1" as the result.
     *           The 'm' flag skips the dynamic checks and only uses dynamic ban lists.
     *
     * 'flags=b' is used when you want to use dynamic ban and dynamic checks with partial bad IP check.
     *
     * 'flags=f' is used when you want to force the system to do a full lookup,
     *           which can take up to 5 seconds.
     *
     * 'flags=n' is used the exclude real time block list.
     *           Append the character "n" if you're already using flags=m, b, or f.
     *
     * @apiNote Fetched from https://getipintel.net/index.php#API
     */
    @Parameter String flags();

    /**
     *
     * 'oflags=b' is used when you want to see if the IP is considered as bad IP.
     *            Note that when using 'flags' option, this result can vary.
     *
     * 'oflags=c' is used when you want to see which country
     *            the IP came from / which country the IP belongs to (GeoIP Location).
     *            Currently in alpha testing.
     *
     * @apiNote Fetched from https://getipintel.net/index.php#API
     */
    @Parameter("oflags") String oFlags();

}
