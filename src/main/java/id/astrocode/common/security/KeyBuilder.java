package id.astrocode.common.security;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/**
 * Key Builder Implementation
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class KeyBuilder {

    private final Encryption encryption;
    private SecurityProvider provider;

    /**
     * Key Builder Constructor
     *
     * @param encryption Encryption Family
     * @see Encryption
     * @since 0.0.1
     */
    public KeyBuilder(Encryption encryption) {
        this.encryption = encryption;
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
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                .getInstance(encryption.getEncryption());
            SecureRandom random = SecureRandom
                .getInstance("SHA1PRNG", String.valueOf(this.provider));
            keyPairGenerator.initialize(this.encryption.getLength(), random);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchProviderException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Build Key Pair
     *
     * @param privateKey Existing Private Key
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair build(PrivateKey privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(encryption.getEncryption());
            System.out.println(encryption.getEncryption());
            if (encryption.getEncryption().equals("RSA")) {
                RSAPrivateKey privateKeyFactory = (RSAPrivateKey) privateKey;
                RSAPublicKeySpec keySpec = new RSAPublicKeySpec(privateKeyFactory.getModulus(),
                    BigInteger.valueOf(65537));
                PublicKey publicKey = keyFactory.generatePublic(keySpec);
                return new KeyPair(publicKey, privateKey);
            } else if (encryption.getEncryption().equals("EC")) {
                ECPrivateKey privateKeyFactory = (ECPrivateKey) privateKey;
                ECParameterSpec parameter = privateKeyFactory.getParams();
                ECPublicKeySpec keySpec = new ECPublicKeySpec(parameter.getGenerator(), parameter);
                PublicKey publicKey = keyFactory.generatePublic(keySpec);
                return new KeyPair(publicKey, privateKey);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}
