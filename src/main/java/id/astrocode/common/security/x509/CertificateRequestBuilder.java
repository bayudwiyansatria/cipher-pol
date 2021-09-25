package id.astrocode.common.security.x509;

import java.security.PublicKey;

/**
 * Certificate Request Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateRequestBuilder {

    private final Signer signer;
    private DistinguishedName distinguishedName;
    private PublicKey publicKey;

    /**
     * Certificate Request Builder Constructor
     *
     * @param signer Signer
     * @see Signer
     * @since 0.0.1
     */
    CertificateRequestBuilder(Signer signer) {
        this.signer = signer;
    }

    /**
     * Set Distinguished Name
     *
     * @param distinguishedName
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
        this.publicKey = publicKey;
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
        return signer.doSign(distinguishedName, publicKey);
    }
}
