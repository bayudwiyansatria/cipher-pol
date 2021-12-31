package com.bayudwiyansatria.security.x509;

/**
 * Certificate Authority
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateAuthority extends Certificate {

    private final Signer signer;

    /**
     * Certificate Authority Constructor
     *
     * @param certificate Certificate
     * @param signer      Signer
     * @see Certificate
     * @see Signer
     * @since 0.0.1
     */
    public CertificateAuthority(Certificate certificate, Signer signer) {
        super(certificate.get());
        this.signer = signer;
    }

    /**
     * Get Certificate Authority Signer
     *
     * @return Signer
     * @see Signer
     * @since 0.0.1
     */
    public Signer getSigner() {
        return this.signer;
    }

    /**
     * Verify Certificate
     *
     * @see Certificate
     * @since 0.0.1
     */
    public void verify(Certificate certificate) {
        try {
            certificate.get().verify(this.signer.getPublicKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
