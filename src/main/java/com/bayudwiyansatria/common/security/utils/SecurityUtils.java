package com.bayudwiyansatria.common.security.utils;

import com.bayudwiyansatria.common.security.Digest;
import java.io.IOException;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Locale;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

/**
 * Security Utils
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class SecurityUtils {

    /**
     * WriteObject To PEM Format
     *
     * @param object Object
     * @return String PEM Format
     * @since 0.0.1
     */
    public String writeToPem(Object object) {
        StringWriter sw = new StringWriter();
        try (JcaPEMWriter writer = new JcaPEMWriter(sw)) {
            writer.writeObject(object);
            writer.flush();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Message Digest
     *
     * @param publicKey PublicKey
     * @return String Message Digest
     * @since 0.0.1
     */
    public String getMessageDigest(PublicKey publicKey) {
        try {
            MessageDigest messageDigest =
                MessageDigest.getInstance(Digest.SHA256.getDigest());
            messageDigest.update(publicKey.getEncoded());
            return this.byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * byteToHex
     *
     * @param bytes byteArray to Hex
     * @return String Hex
     * @since 0.0.1
     */
    private String byteToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString().toUpperCase(Locale.ROOT);
    }
}
