package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import com.bayudwiyansatria.security.utils.SecurityUtils;
import java.math.BigInteger;
import java.security.cert.X509Certificate;

/**
 * Certificate
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class Certificate extends CertificateAbstract<X509Certificate> {

    private final X509Certificate x509Certificate;

    /**
     * Certificate Constructor
     *
     * @param x509Certificate X509 Certificate
     * @since 0.0.1
     */
    public Certificate(X509Certificate x509Certificate) {
        super(x509Certificate);
        this.x509Certificate = x509Certificate;
    }

    /**
     * Certificate Constructor
     *
     * @param x509Certificate ByteArray of X509Certificate
     * @since 0.0.1
     */
    public Certificate(byte[] x509Certificate) {
        super(new SecurityUtils().generateCertificate(x509Certificate));
        this.x509Certificate = new SecurityUtils().generateCertificate(x509Certificate);
    }

    /**
     * Get Certificate Serial Number
     *
     * @return BigInteger Serial Number
     * @since 0.0.1
     */
    public BigInteger getSerialNumber() {
        return this.x509Certificate.getSerialNumber();
    }

    /**
     * Get Issuer Distinguished Name
     *
     * @return Issuer DistinguishedName
     * @see DistinguishedName
     * @since 0.0.1
     */
    public DistinguishedName getIssuer() {
        return new DistinguishedName(this.x509Certificate.getIssuerDN().getName());
    }

    /**
     * Get Subject Distinguished Name
     *
     * @return Subject DistinguishedName
     * @see DistinguishedName
     * @since 0.0.1
     */
    @Override
    public DistinguishedName getSubject() {
        return new DistinguishedName(this.x509Certificate.getSubjectDN().getName());
    }

    /**
     * Get Signature Algorithm
     *
     * @return Signature Algorithm
     * @see SignatureAlgorithm
     * @since 0.0.1
     */
    @Override
    public SignatureAlgorithm getSignatureAlgorithm() {
        return null;
    }

    /**
     * Get Encoded Certificates
     *
     * @return ByteArray of Certificate
     * @since 0.0.1
     */
    @Override
    public byte[] getEncoded() {
        try {
            return this.x509Certificate.getEncoded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Print Certificate
     *
     * @since 0.0.1
     */
    @Override
    public void print() {
        System.out.print(new SecurityUtils().writeToPem(this.x509Certificate));
    }
}
