package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import com.bayudwiyansatria.security.utils.SecurityUtils;
import java.nio.charset.StandardCharsets;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 * Certificate Request Interface
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateRequest extends CertificateAbstract<PKCS10CertificationRequest> {

    private final PKCS10CertificationRequest certificateRequest;

    /**
     * Certificate Request Constructor
     *
     * @param pkcs10CertificationRequest PKCS10CertificationRequest
     * @since 0.0.1
     */
    public CertificateRequest(PKCS10CertificationRequest pkcs10CertificationRequest) {
        super(pkcs10CertificationRequest);
        this.certificateRequest = pkcs10CertificationRequest;
    }

    /**
     * Certificate Request Constructor
     *
     * @param pkcs10CertificationRequest ByteArray of pkcs10CertificationRequest
     * @since 0.0.1
     */
    public CertificateRequest(byte[] pkcs10CertificationRequest) {
        super((PKCS10CertificationRequest) new SecurityUtils().readToPem(
            pkcs10CertificationRequest));
        this.certificateRequest = this.get();
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
        return new DistinguishedName(certificateRequest.getSubject());
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
            return new SecurityUtils().writeToPem(this.certificateRequest)
                .getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
