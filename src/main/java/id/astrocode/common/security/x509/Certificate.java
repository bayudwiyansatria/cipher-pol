package id.astrocode.common.security.x509;

import java.io.File;
import java.security.cert.X509Certificate;

/**
 * Certificate Interface
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public interface Certificate {

    /**
     * X509 Certificate
     *
     * @return X509Certificate
     * @see X509Certificate
     * @since 0.0.1
     */
    X509Certificate getX509Certificate();

    /**
     * Get Subject
     *
     * @return DistinguishedName
     * @see DistinguishedName
     * @since 0.0.1
     */
    DistinguishedName getSubject();

    /**
     * Print the Certificate in PEM Format
     *
     * @return String
     * @since 0.0.1
     */
    String print();

    /**
     * Save Certificate to File
     *
     * @param file File
     * @since 0.0.1
     */
    void save(File file);
}
