package com.bayudwiyansatria.security.x509;

import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;

/**
 * Distinguished Name
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class DistinguishedName {

    private final X500Name x500Name;

    /**
     * Distinguished Name Implementation Constructor
     *
     * @param x500Name X500Name
     * @see X500Name
     * @since 0.0.1
     */
    public DistinguishedName(X500Name x500Name) {
        this.x500Name = x500Name;
    }

    /**
     * Distinguished Name Implementation Constructor
     *
     * @param x500Name String
     * @since 0.0.1
     */
    public DistinguishedName(String x500Name) {
        this.x500Name = new X500Name(x500Name);
    }

    /**
     * Get X500Name RFC-3739
     *
     * @return X500Name
     * @see X500Name
     * @since 0.0.1
     */
    public X500Name getX500Name() {
        return this.x500Name;
    }

    /**
     * Get X500 Principal Name
     *
     * @return X500Principal
     * @see X500Principal
     * @since 0.0.1
     */
    public X500Principal getX500Principal() {
        try {
            return new X500Principal(x500Name.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Encoded Distinguished Name
     *
     * @return ByteArray
     */
    public byte[] getEncoded() {
        try {
            return this.x500Name.getEncoded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Distinguished Name in String
     *
     * @return Distinguished Name
     */
    public String getName() {
        return x500Name.toString();
    }

    /**
     * Get Distinguished Name in String
     *
     * @return Distinguished Name
     */
    public String toString() {
        return getName();
    }
}
