package com.bayudwiyansatria.security.x509;

import java.security.PublicKey;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

/**
 * Certificate Request Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateRequestBuilder {

    private final Signer signer;
    private DistinguishedName distinguishedName;

    /**
     * Certificate Request Builder Constructor
     *
     * @param signer Signer
     * @see Signer
     * @since 0.0.1
     */
    public CertificateRequestBuilder(Signer signer, DistinguishedName distinguishedName) {
        this.signer = signer;
        this.distinguishedName = distinguishedName;
    }

    /**
     * Set Distinguished Name
     *
     * @param distinguishedName DistinguishedName
     * @return CertificateRequestBuilder
     * @see DistinguishedName
     * @since 0.0.1
     */
    public CertificateRequestBuilder setDistinguishedName(DistinguishedName distinguishedName) {
        this.distinguishedName = distinguishedName;
        return this;
    }

    /**
     * Set Public Key
     *
     * @param publicKey Public Key
     * @return CertificateRequestBuilder
     * @see PublicKey
     * @since 0.0.1
     */
    public CertificateRequestBuilder setPublicKey(PublicKey publicKey) {
        return this;
    }

    /**
     * Build Certificate Request
     *
     * @return CertificateRequest
     * @see CertificateRequest
     * @since 0.0.1
     */
    public CertificateRequest build() {
        return new CertificateRequest(
            new JcaPKCS10CertificationRequestBuilder(
                distinguishedName.getX500Name(),
                signer.getKeyPair().getPublic()
            ).build(signer.getContentSigner())
        );
    }
}
