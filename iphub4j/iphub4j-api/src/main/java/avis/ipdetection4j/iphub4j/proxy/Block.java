package avis.ipdetection4j.iphub4j.proxy;

public enum Block {

    /**
     * Residential or business IP (i.e. safe IP)
     */
    SAFE,

    /**
     * Non-residential IP (hosting provider, proxy, etc.)
     */
    PROXY,

    /**
     * NOn-residential & residential IP (warning, may flag innocent people)
     */
    WARNING

}
