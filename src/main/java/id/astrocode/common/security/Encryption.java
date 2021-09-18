package id.astrocode.common.security;

/**
 * Encryption
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum Encryption {
    NONE("NONE"),
    RSA("RSA");

    private final String encryption;

    /**
     * Encryption
     *
     * @param encryption Encryption
     */
    Encryption(String encryption) {
        this.encryption = encryption;
    }

    /**
     * Get Encryption
     *
     * @return encryption
     */
    public String getEncryption() {
        return encryption;
    }
}
