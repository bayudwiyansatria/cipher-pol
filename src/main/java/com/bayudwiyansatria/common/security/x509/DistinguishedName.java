package com.bayudwiyansatria.common.security.x509;

import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;

/**
 * Distingushed Name
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public interface DistinguishedName {

    /**
     * X500Name RFC-3739
     *
     * @return X500Name
     * @see X500Name
     * @since 0.0.1
     */
    X500Name getX500Name();

    /**
     * X500Principal Name
     *
     * @return X500Principal
     * @see X500Principal
     * @since 0.0.1
     */
    X500Principal getX500Principal();

    /**
     * Get Encoded Distinguished Name
     *
     * @return ByteArray
     * @since 0.0.1
     */
    byte[] getEncoded();

    /**
     * X500Name String format
     *
     * @return String
     * @since 0.0.1
     */
    String getName();
}
