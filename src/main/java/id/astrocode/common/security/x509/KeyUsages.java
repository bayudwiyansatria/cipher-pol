package id.astrocode.common.security.x509;

/**
 * Key Usages
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum KeyUsages {
    /**
     * Digital Signature
     */
    DIGITAL_SIGNATURE("digitalSignature", "Digital Signature"),

    /**
     * Non Repudiation
     */
    NON_REPUDIATION("nonRepudiation", "Non Repudiation"),

    /**
     * Key Encipherment
     */
    KEY_ENCIPHERING("keyEncipherment", "Key Encipherment"),

    /**
     * Data Encipherment
     */
    DATA_ENCIPHERING("dataEncipherment", "Data Encipherment"),

    /**
     * Key Agreement
     */
    KEY_AGREEMENT("keyAgreement", "Key Agreement"),

    /**
     * Key Certificate Sign
     */
    KEY_CERT_SIGN("keyCertSign", "Key Certificate Signer"),

    /**
     * Certificate Revocation List Signer
     */
    CRL_SIGN("cRLSign", "Certificate Revocation List Signer"),

    /**
     * Encipher Only
     */
    ENCIPHER_ONLY("encipherOnly", "Encipher Only"),

    /**
     * Decipher Only
     */
    DECIPHER_ONLY("decipherOnly", "decipherOnly");

    private final String jcaName;
    private final String description;

    /**
     * Certificate Key Usages
     *
     * @param jcaName     JCA Name
     * @param description Description
     * @since 0.0.1
     */
    KeyUsages(String jcaName, String description) {
        this.jcaName = jcaName;
        this.description = description;
    }

    /**
     * Get Java Cryptography Architecture Name
     *
     * @return String
     * @since 0.0.1
     */
    public String getJcaName() {
        return jcaName;
    }

    /**
     * Get Key Usage Description
     *
     * @return Description
     * @since 0.0.1
     */
    public String getDescription() {
        return description;
    }
}
