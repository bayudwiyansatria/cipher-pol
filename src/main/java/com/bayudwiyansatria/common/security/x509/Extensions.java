package com.bayudwiyansatria.common.security.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/**
 * Certificate Extensions
 *
 * @author Bayu Dwiyan Satria
 * @value 0.0.1
 */
public class Extensions {

    private final ASN1ObjectIdentifier oid;
    private final ASN1Encodable value;

    /**
     * Certificate Extension Constructor
     *
     * @param oid        Object Identifier
     * @param isCritical Critical
     * @param value      Object Identifier Value
     * @see ASN1ObjectIdentifier
     * @see ASN1Encodable
     * @since 0.0.1
     */
    Extensions(ASN1ObjectIdentifier oid, boolean isCritical, ASN1Encodable value) {
        this.oid = oid;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Extensions: [" + oid + "=" + value + "]";
    }

}
