package com.bayudwiyansatria.common.security.x509.impl;

import com.bayudwiyansatria.common.security.utils.SecurityUtils;
import com.bayudwiyansatria.common.security.x509.Certificate;
import com.bayudwiyansatria.common.security.x509.DistinguishedName;
import java.io.File;
import java.security.cert.X509Certificate;

/**
 * Certificate Implementation
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateImpl implements Certificate {

    private final X509Certificate certificate;

    /**
     * Certificate Implementation Constructor
     *
     * @param certificate Certificate
     * @see X509Certificate
     * @since 0.0.1
     */
    public CertificateImpl(X509Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public X509Certificate getX509Certificate() {
        return certificate;
    }

    @Override
    public DistinguishedName getSubject() {
        return new DistinguishedNameImpl(certificate.getSubjectX500Principal().getName());
    }

    @Override
    public String print() {
        return new SecurityUtils().writeToPem(certificate);
    }

    @Override
    public void save(File file) {

    }
}
