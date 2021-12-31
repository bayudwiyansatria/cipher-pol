package com.bayudwiyansatria.security;

import com.bayudwiyansatria.common.security.KeyBuilder;
import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import com.bayudwiyansatria.security.x509.Certificate;
import com.bayudwiyansatria.security.x509.CertificateAuthority;
import com.bayudwiyansatria.security.x509.CertificateBuilder;
import com.bayudwiyansatria.security.x509.CertificateRequest;
import com.bayudwiyansatria.security.x509.CertificateRequestBuilder;
import com.bayudwiyansatria.security.x509.DistinguishedName;
import com.bayudwiyansatria.security.x509.DistinguishedNameBuilder;
import com.bayudwiyansatria.security.x509.Signer;
import java.security.KeyPair;
import java.security.cert.CertificateException;
import org.junit.Assert;
import org.junit.Test;

public class CertificateTest {

    private final DistinguishedName distinguishedName = new DistinguishedNameBuilder()
        .setCommonName("bayudwiyansatria.com")
        .build();
    private final KeyPair keyPair = new KeyBuilder().build();
    private final Signer signer = new Signer(SignatureAlgorithm.RS512, keyPair);

    @Test
    public void doTest() throws CertificateException {
        // Generate Certificate Request With Builder
        CertificateRequest certificateRequest = this.generateCertificateRequestFromBuilder();

        // Get Certificate Request in Bytes
        byte[] certificateRequestInBytes = certificateRequest.getEncoded();

        // Generate Certificate Request From Bytes Array
        certificateRequest = this.generateCertificateRequestFromBytes(certificateRequestInBytes);

        // Matching Certificate Request
        Assert.assertEquals(distinguishedName.toString(),
            certificateRequest.getSubject().toString());
//        certificateRequest.save(new File("bayudwiyansatria.com.csr"));

        // Generate SelfSign Certificate With Builder
        Certificate certificate = this.generateCertificateFromBuilder(certificateRequest);

        // Get Certificate in Bytes
        byte[] certificateInBytes = certificate.getEncoded();

        // Generate SelfSign Certificate From Bytes
        certificate = this.generateCertificateFromBytes(certificateInBytes);

        // Matching Certificate
        Assert.assertEquals(certificate.getIssuer().toString(),
            certificate.getSubject().toString());
//        certificate.save(new File("bayudwiyansatria.com.crt"));

        // Generate CertificateAuthority
        CertificateAuthority certificateAuthority = this.generateCertificateAuthority(certificate);

        // Check Public Key Is Match
        Assert.assertEquals(certificateAuthority.getSigner().getPublicKey(), signer.getPublicKey());

        // Generate Client Certificate
        KeyPair clientKeyPair = new KeyBuilder().build();
        Certificate clientCertificate = new CertificateBuilder(
            certificateAuthority,
            new CertificateRequestBuilder(
                new Signer(SignatureAlgorithm.RS512, clientKeyPair),
                new DistinguishedNameBuilder()
                    .setCommonName("pki.bayudwiyansatria.com")
                    .build()
            ).build()
        ).build();

        certificateAuthority.verify(clientCertificate);

    }

    private CertificateRequest generateCertificateRequestFromBuilder() {
        CertificateRequest certificateRequest = new CertificateRequestBuilder(signer,
            distinguishedName).build();
        certificateRequest.print();
        return certificateRequest;
    }

    private CertificateRequest generateCertificateRequestFromBytes(
        byte[] certificateRequestInBytes) {
        CertificateRequest certificateRequest = new CertificateRequest(certificateRequestInBytes);
        certificateRequest.print();
        return certificateRequest;
    }

    private Certificate generateCertificateFromBuilder(CertificateRequest certificateRequest) {
        Certificate certificate = new CertificateBuilder(signer, distinguishedName,
            certificateRequest).build();
        certificate.print();
        return certificate;
    }

    private Certificate generateCertificateFromBytes(byte[] certificateInBytes) {
        Certificate certificate = new Certificate(certificateInBytes);
        certificate.print();
        return certificate;
    }

    private CertificateAuthority generateCertificateAuthority(Certificate certificate) {
        CertificateAuthority certificateAuthority = new CertificateAuthority(certificate, signer);
        certificateAuthority.print();
        return certificateAuthority;
    }
}
