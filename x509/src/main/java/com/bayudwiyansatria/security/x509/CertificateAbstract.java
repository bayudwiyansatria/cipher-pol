package com.bayudwiyansatria.security.x509;

import com.bayudwiyansatria.security.utils.SecurityUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Certificate Abstract
 *
 * @param <T>
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @see CertificateBase
 */
abstract class CertificateAbstract<T> implements CertificateBase {

    private final T certificate;

    /**
     * Certificate
     *
     * @param certificate Certificate Type
     * @since 0.0.1
     */
    CertificateAbstract(T certificate) {
        this.certificate = certificate;
    }

    /**
     * Get Certificate
     *
     * @return Certificate
     * @since 0.0.1
     */
    public T get() {
        return certificate;
    }

    /**
     * Save Certificate to File
     *
     * @param file File Path to Save
     * @since 0.0.1
     */
    public void save(File file) {
        try {
            Files.newBufferedWriter(
                file.toPath(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print Certificate in PEM Format
     *
     * @since 0.0.1
     */
    public void print() {
        System.out.print(new SecurityUtils().writeToPem(certificate));
    }
}
