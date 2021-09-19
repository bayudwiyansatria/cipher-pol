package id.astrocode.common.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Signature Alogrithm
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @since 0.0.1
 */
public enum SignatureAlgorithm {
    /**
     * for `No digital signature`
     */
    NONE("none", "No digital signature", "", "", 0),

    /**
     * for `HMAC using SHA-256`
     */
    HS256("HS256", "HMAC using SHA-256", "", "HmacSHA256", 256),

    /**
     * for `HMAC using SHA-512`
     */
    HS512("HS512", "HMAC using SHA-512", "RSA", "HmacSHA512", 512),

    /**
     * for `RSASSA-PKCS-v1_5 using SHA-256`
     */
    RS256("RS256", "RSASSA-PKCS-v1_5 using SHA-256", "RSA", "SHA256withRSA", 2048),

    /**
     * for `RSASSA-PKCS-v1_5 using SHA-512`
     */
    RS512("RS512", "RSASSA-PKCS-v1_5 using SHA-512", "RSA", "SHA512withRSA", 2048),

    /**
     * for `ECDSA using P-256 using SHA-256`
     */
    ES256("ES256", "ECDSA using P-256 and SHA-256", "ECDSA", "secp256r1", 256),

    /**
     * for `ECDSA using P-512 using SHA-256`
     */
    ES512("ES512", "ECDSA using P-512 and SHA-512", "ECDSA", "secp521r1", 512);

    private static final List<SignatureAlgorithm> PREFERRED_HMAC_ALGORITHM = Collections
        .unmodifiableList(Arrays.asList(HS512, HS256));
    private static final List<SignatureAlgorithm> PREFERRED_EC_ALGORITHM = Collections
        .unmodifiableList(Arrays.asList(ES512, ES256));
    private final String value;
    private final String description;
    private final String familyName;
    private final String jcaName;
    private final int digestLength;

    /**
     * Signature Algorithm
     *
     * @param value        Algorithm
     * @param description  Description
     * @param jcaName      JCA Name
     * @param digestLength Disgest Length
     * @since 0.0.1
     */
    SignatureAlgorithm(String value, String description, String familyName, String jcaName,
        int digestLength) {
        this.value = value;
        this.description = description;
        this.familyName = familyName;
        this.jcaName = jcaName;
        this.digestLength = digestLength;
    }

    public String getValue() {
        return value;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDescription() {
        return description;
    }

    public String getJcaName() {
        return jcaName;
    }

    public int getDigestLength() {
        return digestLength;
    }

}
