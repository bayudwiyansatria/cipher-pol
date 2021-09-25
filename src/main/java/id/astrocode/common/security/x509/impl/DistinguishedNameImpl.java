package id.astrocode.common.security.x509.impl;

import id.astrocode.common.security.x509.DistinguishedName;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;

/**
 * Distinguished Name Implementation
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class DistinguishedNameImpl implements DistinguishedName {

    private final X500Name x500Name;

    /**
     * Distinguished Name Implementation Constructor
     *
     * @param x500Name X500Name
     * @see X500Name
     * @since 0.0.1
     */
    public DistinguishedNameImpl(X500Name x500Name) {
        this.x500Name = x500Name;
    }

    /**
     * Distinguished Name Implementation Constructor
     *
     * @param x500Name String
     * @since 0.0.1
     */
    public DistinguishedNameImpl(String x500Name) {
        this.x500Name = new X500Name(x500Name);
    }

    /**
     * Get X500 Name
     *
     * @return X500Name
     * @see X500Name
     * @since 0.0.1
     */
    @Override
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
    @Override
    public X500Principal getX500Principal() {
        try {
            return new X500Principal(x500Name.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] getEncoded() {
        try {
            return this.x500Name.getEncoded();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return x500Name.toString();
    }

    public String toString() {
        return getName();
    }
}
