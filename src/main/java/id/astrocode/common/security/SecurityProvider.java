package id.astrocode.common.security;

/**
 * Security Provider
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum SecurityProvider {
    /**
     * SUN Provider
     */
    SUN("SUN"),

    /**
     * Bounce Castle Provider
     */
    BC("BouncyCastle");

    private final String provider;

    SecurityProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
}
