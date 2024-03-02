package com.bayudwiyansatria.security.x509;

public class CertificateChain {

    private final Certificate rootCertificate;
    private final Certificate intermediateCertificate;
    private final Certificate certificate;

    CertificateChain(
        Certificate rootCertificate,
        Certificate certificate
    ) {
        this.rootCertificate = rootCertificate;
        this.intermediateCertificate = null;
        this.certificate = certificate;
    }

    CertificateChain(
        Certificate rootCertificate,
        Certificate intermediateCertificate,
        Certificate certificate
    ) {
        this.rootCertificate = rootCertificate;
        this.intermediateCertificate = intermediateCertificate;
        this.certificate = certificate;
    }

    public Certificate[] get() {
        Certificate[] chain = intermediateCertificate == null
            ? new Certificate[2]
            : new Certificate[3];
        chain[0] = this.rootCertificate;
        if (intermediateCertificate == null) {
            chain[1] = certificate;
        } else {
            chain[1] = intermediateCertificate;
            chain[2] = certificate;
        }
        return chain;
    }
}
