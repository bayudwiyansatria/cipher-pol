package com.bayudwiyansatria.common.security.key.ecc;

import com.bayudwiyansatria.common.security.Encryption;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;

/**
 * ECC Key Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class ECKeyBuilder {

    private final String encryption = Encryption.EC.getEncryption();

    /**
     * Generate ECC KeyPair
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
            return this.build((ECPrivateKey) keyPair.getPrivate());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Generate ECC KeyPair
     *
     * @param privateKey ECPrivateKey
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair build(ECPrivateKey privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(this.encryption);
            ECParameterSpec parameter = privateKey.getParams();
            ECPublicKeySpec keySpec = new ECPublicKeySpec(parameter.getGenerator(), parameter);
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new KeyPair(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
