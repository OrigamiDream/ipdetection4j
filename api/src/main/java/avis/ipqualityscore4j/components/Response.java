package avis.ipqualityscore4j.components;

import avis.ipqualityscore4j.annotations.Generic;

import java.util.List;

public interface Response {

    /**
     *
     * A unique identifier for this request that can be used to lookup
     * the request details or send a postback conversion notice.
     *
     * @return {@link String}
     */
    String requestId();

    /**
     *
     * Array of errors which occurred while attempting to process this request.
     *
     * @return {@link List<String>}
     */
    @Generic(String.class) List<String> errors();

    /**
     *
     * A generic status messages,
     * either success or some form of an error notice.
     *
     * @return {@link String}
     */
    String message();

    /**
     *
     * Was the request successful?
     *
     * @return {@link Boolean}
     */
    boolean success();

}
