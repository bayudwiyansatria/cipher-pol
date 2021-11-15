package com.bayudwiyansatria.common.security.x509;

/**
 * Extended Key Usage Type
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum ExtendedKeyUsageType {
    /**
     * TLS Web Server Authentication
     */
    SERVER_AUTH("1.3.6.1.5.5.7.3.1", "ServerAuthExtKeyUsage"),

    /**
     * TLS Web Client Authentication
     */
    CLIENT_AUTH("1.3.6.1.5.5.7.3.2", "ClientAuthExtKeyUsage"),

    /**
     * Code Signing
     */
    CODE_SIGNING("1.3.6.1.5.5.7.3.3", "CodeSigningExtKeyUsage"),

    /**
     * Document Signing
     */
    DOCUMENT_SIGNING("1.3.6.1.4.1.311.10.3.12", "DocumentSigningExtKeyUsage"),

    /**
     * Adobe PDF Signing
     */
    ADOBE_PDF_SIGNING("1.2.840.113583.1.1.5", "AdobePDFSigningExtKeyUsage"),

    /**
     * Encrypted File System
     */
    ENCRYPTED_FILE_SYSTEM("1.3.6.1.4.1.311.10.3.4", "EncryptedFileSystemExtKeyUsage"),

    /**
     * Smartcard Logon
     */
    SMARTCARD_LOGON("1.3.6.1.4.1.311.20.2.2", "SmartcardLogonExtKeyUsage"),

    /**
     * Any EXtended Key Usage
     */
    ANY_EXTENDED_KEY_USAGE("2.5.29.37.0", "AnyExtendedKeyUsageExtKeyUsage"),

    /**
     * E-mail Protection
     */
    EMAIL_PROTECTION("1.3.6.1.5.5.7.3.4", "EmailProtectionExtKeyUsage"),

    /**
     * IP Security End System
     */
    IPSEC_END_SYSTEM("1.3.6.1.5.5.7.3.5", "IpsecEndSystemExtKeyUsage"),

    /**
     * IP Security Tunnel termination
     */
    IPSEC_TUNNEL("1.3.6.1.5.5.7.3.6", "IpsecTunnelExtKeyUsage"),

    /**
     * IP Security User
     */
    IPSEC_USER("1.3.6.1.5.5.7.3.7", "IpsecUserExtKeyUsage"),

    /**
     * Time Stamping
     */
    TIME_STAMPING("1.3.6.1.5.5.7.3.8", "TimeStampingExtKeyUsage"),

    /**
     * OCSP Signing
     */
    OCSP_SIGNING("1.3.6.1.5.5.7.3.9", "OcspSigningExtKeyUsage"),

    /**
     * Microsoft Server Gated Crypto (SGC)
     */
    MICROSOFT_SGC("1.3.6.1.4.1.311.10.3.3", "MicrosoftSGCExtKeyUsage"),

    /**
     * Netscape Server Gated Crypto (SGC)
     */
    NETSCAPE_SGC("2.16.840.1.113730.4.1", "NetscapeSGCExtKeyUsage"),

    /**
     * Microsoft Server Gated Crypto (SGC)
     */
    VERISIGN_SGC("2.16.840.1.113733.1.8.1", "VeriSignSGCExtKeyUsage"),

    /**
     * TSL signing specified by ETSI TS 102 231 V3.1.2 for the purpose of signing Trust-service
     * Status Lists.
     */
    TSL_SIGNING("0.4.0.2231.3.0", "TSLSignExtKeyUsage");

    private final String oid;
    private final String jcaName;

    /**
     * Certificate Extended Key Usages
     *
     * @param oid
     * @param jcaName
     */
    ExtendedKeyUsageType(String oid, String jcaName) {
        this.oid = oid;
        this.jcaName = jcaName;
    }

    public String getOid() {
        return oid;
    }

    public String getJcaName() {
        return jcaName;
    }

}
