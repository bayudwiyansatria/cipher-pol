package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import java.io.File;

/**
 * Certificate Interface
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
interface CertificateBase {

    /**
     * Get Issuer Certificate
     *
     * @return DistinguishedName
     * @see DistinguishedName
     * @since 0.0.1
     */
    DistinguishedName getSubject();

    /**
     * Get Signature Algorithm
     *
     * @return Signature Alogrithm
     * @see SignatureAlgorithm
     * @since 0.0.1
     */
    SignatureAlgorithm getSignatureAlgorithm();

    /**
     * Get Certificate Encoded
     *
     * @return ByteArray of Certificate
     * @since 0.0.1
     */
    byte[] getEncoded();

    /**
     * Print Certificate
     *
     * @since 0.0.1
     */
    void print();

    /**
     * Save Certificate
     *
     * @since 0.0.1
     */
    void save(File file);
}
