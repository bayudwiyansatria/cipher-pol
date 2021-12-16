package com.bayudwiyansatria.common.security.key.rsa;

import com.bayudwiyansatria.common.security.Encryption;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPublicKeySpec;

/**
 * RSA Key Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class RSAKeyBuilder {

    private final String encryption = Encryption.RSA.getEncryption();

    /**
     * Generate RSA KeyPair
     *
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair build() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                .getInstance(this.encryption);
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return this.build((RSAPrivateKey) keyPair.getPrivate());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Generate RSA KeyPair
     *
     * @param privateKey RSAPrivate Key
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair build(RSAPrivateKey privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(this.encryption);
            RSAPublicKeySpec keySpec =
                new RSAPublicKeySpec(privateKey.getModulus(), BigInteger.valueOf(65537));
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new KeyPair(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
