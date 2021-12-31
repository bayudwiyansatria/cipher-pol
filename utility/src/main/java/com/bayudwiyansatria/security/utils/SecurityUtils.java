package com.bayudwiyansatria.security.utils;

import com.bayudwiyansatria.common.Utils;
import com.bayudwiyansatria.common.security.Digest;
import com.bayudwiyansatria.common.security.pem.PEMReader;
import com.bayudwiyansatria.common.security.pem.PEMWriter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Security Utils
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class SecurityUtils extends Utils {

    /**
     * Generate Certificate with Factory
     *
     * @param x509Certificate ByteArray Of Certificate
     * @return X509Certificate
     * @since 0.0.1
     */
    public X509Certificate generateCertificate(byte[] x509Certificate) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
            return (X509Certificate) certificateFactory
                .generateCertificate(
                    new ByteArrayInputStream(x509Certificate)
                );
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read Certificate From Bytes to PEM Format
     *
     * @param base64 Base64
     * @return Object
     * @since 0.0.1
     */
    public Object readToPem(byte[] base64) {
        ByteArrayInputStream inputStream;
        try {
            inputStream = new ByteArrayInputStream(base64);
            Reader reader = new BufferedReader(new InputStreamReader(inputStream));
            PEMReader pemParser = new PEMReader(reader);
            return pemParser.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read Certificate From Bytes to PEM Format
     *
     * @param base64 Base64
     * @return Object
     * @since 0.0.1
     */
    public Object readToPem(String base64) {
        return this.readToPem(base64.getBytes());
    }

    /**
     * WriteObject To PEM Format
     *
     * @param object Object
     * @return String PEM Format
     * @since 0.0.1
     */
    public String writeToPem(Object object) {
        StringWriter sw = new StringWriter();
        try (PEMWriter writer = new PEMWriter(sw)) {
            writer.writeObject(object);
            writer.flush();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * WriteObject To PEM Format
     *
     * @param object Object
     * @return String PEM Format
     * @since 0.0.1
     */
    public byte[] writeToBase64(Object object) {
        return this.writeToPem(object).getBytes();
    }

    /**
     * Get Message Digest
     *
     * @param publicKey PublicKey
     * @return String Message Digest
     * @since 0.0.1
     */
    public String getMessageDigest(PublicKey publicKey, Digest digest) {
        try {
            MessageDigest messageDigest =
                MessageDigest.getInstance(digest.getDigest());
            messageDigest.update(publicKey.getEncoded());
            return this.byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
