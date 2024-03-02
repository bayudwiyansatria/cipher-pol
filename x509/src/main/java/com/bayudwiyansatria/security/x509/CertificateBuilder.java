package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.common.security.SerialNumberGenerator;
import com.bayudwiyansatria.common.security.x509.KeyUsages;
import com.bayudwiyansatria.security.utils.SecurityUtils;
import java.security.cert.CertificateException;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;

/**
 * Certificate Builder
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateBuilder {

    private final CertificateRequest certificateRequest;
    private final DistinguishedName issuerDistinguishedName;
    private final Signer signer;

    public CertificateBuilder() {
        this.certificateRequest = null;
        this.issuerDistinguishedName = null;
        this.signer = null;
    }

    /**
     * Certificate Builder Constructor
     *
     * @param certificateAuthority CertificateAuthority
     * @param certificateRequest   CertificateRequest
     * @see CertificateAuthority
     * @see CertificateRequest
     * @since 0.0.1
     */
    public CertificateBuilder(
        CertificateAuthority certificateAuthority,
        CertificateRequest certificateRequest
    ) {
        this.signer = certificateAuthority.getSigner();
        this.issuerDistinguishedName = certificateAuthority.getSubject();
        this.certificateRequest = certificateRequest;
    }

    /**
     * Certificate Builder Constructor
     *
     * @param signer                  Signer
     * @param issuerDistinguishedName DistinguishedName
     * @param certificateRequest      CertificateRequest
     * @see DistinguishedName
     * @see CertificateRequest
     * @see Signer
     * @since 0.0.1
     */
    public CertificateBuilder(
        Signer signer,
        DistinguishedName issuerDistinguishedName,
        CertificateRequest certificateRequest
    ) {
        this.signer = signer;
        this.issuerDistinguishedName = issuerDistinguishedName;
        this.certificateRequest = certificateRequest;
    }

    /**
     * Set Key Usages
     *
     * @param keyUsages KeyUsages
     * @return CertificateBuilder
     * @see KeyUsages
     * @since 0.0.1
     */
    public CertificateBuilder setKeyUsages(KeyUsages[] keyUsages) {
        return this;
    }

    /**
     * Build Certificate from Bytes
     *
     * @param x509Certificate x509Certificate
     * @return Certificate
     * @since 1.0.2
     */
    public Certificate build(byte[] x509Certificate) {
        return new Certificate(new SecurityUtils().generateCertificate(x509Certificate));
    }

    /**
     * Build Certificate from Base64 Encoded
     *
     * @param x509Certificate X509Certificate
     * @return Certificate
     * @since 1.0.2
     */
    public Certificate build(String x509Certificate) {
        return this.build(Base64.getDecoder().decode(x509Certificate));
    }

    /**
     * Build Certificate
     *
     * @return Certificate
     * @see Certificate
     * @since 0.0.1
     */
    public Certificate build() {
        try {
            X509v3CertificateBuilder certificateBuilder = new X509v3CertificateBuilder(
                this.issuerDistinguishedName.getX500Name(),
                new SerialNumberGenerator().generateRandomSerialNumber(),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                this.certificateRequest.getSubject().getX500Name(),
                this.certificateRequest.get().getSubjectPublicKeyInfo()
            );
            X509CertificateHolder holder = certificateBuilder.build(signer.getContentSigner());
            return new Certificate(new JcaX509CertificateConverter().getCertificate(holder));
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
