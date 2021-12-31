package com.bayudwiyansatria.common.security;

import com.bayudwiyansatria.common.security.key.ecc.ECKeyBuilder;
import com.bayudwiyansatria.common.security.key.rsa.RSAKeyBuilder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Key Builder Implementation
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class KeyBuilder {

    private KeyPair keyPair;
    private Encryption encryption = Encryption.RSA;
    private SecurityProvider provider = SecurityProvider.BC;
    private int keySize = 2048;

    /**
     * Key Builder Constructor
     *
     * @since 0.0.1
     */
    public KeyBuilder() {
    }

    public KeyBuilder(PrivateKey privateKey) {
        this.keyPair = this.build(privateKey);
    }

    public KeyBuilder(String keyType, byte[] privateKey) {
        this.keyPair = this.build(keyType, privateKey);
    }

    /**
     * Set PrivateKey
     *
     * @param privateKey PrivateKey
     * @return KeyPair
     */
    public KeyPair setPrivateKey(PrivateKey privateKey) {
        return this.build(privateKey);
    }

    /**
     * Set Encryption
     *
     * @param encryption encryption
     * @return KeyBuilder
     * @see Encryption
     * @since 0.0.1
     */
    public KeyBuilder setEncryption(Encryption encryption) {
        this.encryption = encryption;
        return this;
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
     * Set Key Size
     *
     * @param keySize keySize
     * @return KeyBuilder
     * @since 0.0.1
     */
    public KeyBuilder setSize(int keySize) {
        this.keySize = keySize;
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
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                .getInstance(this.encryption.getEncryption(), provider.getProvider());
            keyPairGenerator.initialize(this.keySize);
            this.keyPair = keyPairGenerator.generateKeyPair();
            return this.build(keyPair.getPrivate());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Build KeyPair from Existing Encoded PrivateKey
     *
     * @param keyType    Key Type i.e RSA, ECC
     * @param privateKey Encoded PrivateKey
     * @return KeyPair
     * @since 0.0.1
     */
    private KeyPair build(String keyType, byte[] privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(keyType);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
            PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(privateKey));
            this.keyPair = new KeyPair(
                publicKey,
                keyFactory.generatePrivate(keySpec)
            );
            return this.build(keyPair.getPrivate());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
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
    private KeyPair build(PrivateKey privateKey) {
        if (encryption.getEncryption().equals("RSA")) {
            return new RSAKeyBuilder().build((RSAPrivateKey) privateKey);
        } else if (encryption.getEncryption().equals("EC")) {
            return new ECKeyBuilder().build((ECPrivateKey) privateKey);
        }
        return null;
    }
}

