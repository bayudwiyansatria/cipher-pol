package com.bayudwiyansatria.common.security;

/**
 * Encryption
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum Encryption {
    NONE("NONE", 0),
    RSA2048("RSA", 2048),
    RSA4096("RSA", 4096),
    EC256("EC", 256),
    EC512("EC", 512);

    private final String encryption;
    private final int length;

    /**
     * Encryption
     *
     * @param encryption Encryption
     */
    Encryption(String encryption, int length) {
        this.encryption = encryption;
        this.length = length;
    }

    /**
     * Get Encryption
     *
     * @return encryption
     */
    public String getEncryption() {
        return encryption;
    }

    /**
     * Get Encryption Key Length
     *
     * @return encryption
     */
    public int getLength() {
        return length;
    }
}
