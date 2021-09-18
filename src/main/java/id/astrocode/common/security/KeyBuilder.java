package id.astrocode.common.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * Key Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class KeyBuilder {

    private KeyPairGenerator keyPairGenerator;
    private SecurityProvider provider;

    /**
     * Set KeyPair Encryption
     *
     * @param encryption Encryption of Key i.e RSA
     * @return KeyBuilder
     * @see Encryption
     * @since 0.0.1
     */
    public KeyBuilder setEncryption(Encryption encryption) {
        try {
            this.keyPairGenerator = KeyPairGenerator.getInstance(encryption.getEncryption());
            return this;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Set Key Provider
     *
     * @param provider Security Provider
     * @return KeyBuilder
     * @see SecurityProvider
     * @since 0.0.1
     */
    public KeyBuilder setProvider(SecurityProvider provider) {
        this.provider = provider;
        return this;
    }

    /**
     * Build Key Pair
     *
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair build() {
        if (this.provider == null) {
            this.provider = SecurityProvider.SUN;
        }
        try {
            SecureRandom random = SecureRandom
                .getInstance("SHA1PRNG", String.valueOf(this.provider));
            keyPairGenerator.initialize(2048, random);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchProviderException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
