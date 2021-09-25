package id.astrocode.common.security.utils;

import id.astrocode.common.security.x509.Certificate;
import id.astrocode.common.security.x509.CertificateRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.X509Certificate;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 * X5009 Utility
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class X509Utils {

    /**
     * Get Certificate in PEM Format
     *
     * @param certificateRequest Certificate Request
     * @return PEM Format
     * @see CertificateRequest
     * @since 0.0.1
     */
    public String writeToPem(CertificateRequest certificateRequest) {
        return this.writeToPem(certificateRequest.getPKCS10CertificationRequest());
    }

    /**
     * Get Certificate in PEM Format
     *
     * @param certificateRequest Certificate Request
     * @return PEM Format
     * @see PKCS10CertificationRequest
     * @since 0.0.1
     */
    public String writeToPem(PKCS10CertificationRequest certificateRequest) {
        StringWriter sw = new StringWriter();
        try (JcaPEMWriter writer = new JcaPEMWriter(sw)) {
            writer.writeObject(certificateRequest);
            writer.flush();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Certificate in PEM Format
     *
     * @param certificate Certificate
     * @return PEM Format
     * @see Certificate
     * @since 0.0.1
     */
    public String writeToPem(Certificate certificate) {
        return this.writeToPem(certificate.getX509Certificate());
    }

    /**
     * Get Certificate in PEM Format
     *
     * @param certificate Certificate
     * @return PEM Format
     * @see Certificate
     * @since 0.0.1
     */
    public String writeToPem(X509Certificate certificate) {
        StringWriter sw = new StringWriter();
        try (JcaPEMWriter writer = new JcaPEMWriter(sw)) {
            writer.writeObject(certificate);
            writer.flush();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
