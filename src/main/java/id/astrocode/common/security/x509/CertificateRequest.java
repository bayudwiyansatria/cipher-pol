package id.astrocode.common.security.x509;

import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 * Certificate Request Interface
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public interface CertificateRequest {

    /**
     * Get Certificate Request
     *
     * @return PKCS10CertificationRequest Certificate Request (CSR)
     * @see PKCS10CertificationRequest
     * @since 0.0.1
     */
    PKCS10CertificationRequest getPKCS10CertificationRequest();

    /**
     * Certificate Request Subject
     *
     * @return DistinguishedName
     * @since 0.0.1
     */
    DistinguishedName getSubject();

    /**
     * Print the Certificate Request (CSR)
     *
     * @return Certificate Request PEM Format
     * @since 0.0.1
     */
    String print();

}
