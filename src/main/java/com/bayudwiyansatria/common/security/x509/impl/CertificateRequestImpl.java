package com.bayudwiyansatria.common.security.x509.impl;

import com.bayudwiyansatria.common.security.utils.SecurityUtils;
import com.bayudwiyansatria.common.security.x509.CertificateRequest;
import com.bayudwiyansatria.common.security.x509.DistinguishedName;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 * Certificate Request Implementation
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateRequestImpl implements CertificateRequest {

    private final PKCS10CertificationRequest pkcs10CertificationRequest;

    /**
     * Certificate Request Implementation Constructor
     *
     * @param pkcs10CertificationRequest Certificate Request
     * @since 0.0.1
     */
    public CertificateRequestImpl(PKCS10CertificationRequest pkcs10CertificationRequest) {
        this.pkcs10CertificationRequest = pkcs10CertificationRequest;
    }

    @Override
    public PKCS10CertificationRequest getPKCS10CertificationRequest() {
        return pkcs10CertificationRequest;
    }

    @Override
    public DistinguishedName getSubject() {
        return new DistinguishedNameImpl(pkcs10CertificationRequest.getSubject());
    }

    @Override
    public String print() {
        return new SecurityUtils().writeToPem(pkcs10CertificationRequest);
    }

}
