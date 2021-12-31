package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.common.security.KeyBuilder;
import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

/**
 * Signer
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class Signer {

    private final KeyPair keyPair;
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;

    /**
     * Signer Constructor
     *
     * @since 0.0.1
     */
    public Signer() {
        this.keyPair = new KeyBuilder().build();
    }

    /**
     * Using Predefined Signer
     *
     * @param signatureAlgorithm Signature Algorithm
     * @param keyPair            KeyPair
     * @see SignatureAlgorithm
     * @see PrivateKey
     * @since 0.0.1
     */
    public Signer(
        SignatureAlgorithm signatureAlgorithm,
        KeyPair keyPair
    ) {
        this.signatureAlgorithm = signatureAlgorithm;
        this.keyPair = keyPair;
    }

    /**
     * Get Content Signer
     *
     * @return ContentSigner
     * @since 0.0.1
     */
    public ContentSigner getContentSigner() {
        try {
            return new JcaContentSignerBuilder(signatureAlgorithm.getJcaName()).build(
                this.keyPair.getPrivate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get KeyPair Contain PublicKey and PrivateKey
     *
     * @return KeyPair
     * @see KeyPair
     * @since 0.0.1
     */
    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    /**
     * Get PublicKey
     *
     * @return PublicKey
     * @see PublicKey
     * @since 0.0.1
     */
    public PublicKey getPublicKey() {
        return this.keyPair.getPublic();
    }

    /**
     * Get PrivateKey
     *
     * @return PrivateKey
     * @see PrivateKey
     * @since 0.0.1
     */
    public PrivateKey getPrivateKey() {
        return this.keyPair.getPrivate();
    }

}
