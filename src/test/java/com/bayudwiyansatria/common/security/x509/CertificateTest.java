package com.bayudwiyansatria.common.security.x509;

import com.bayudwiyansatria.common.security.Encryption;
import com.bayudwiyansatria.common.security.KeyBuilder;
import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import java.security.KeyPair;
import org.junit.Test;

/**
 * Certificate Test
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateTest {

    @Test
    public void generateSelfSignCertificate() {
        DistinguishedName distinguishedName = new DistinguishedNameBuilder()
            .setCommonName("bayudwiyansatria.com")
            .setOrganizationName("Bayu Dwiyan Satria")
            .setOrganizationalUnitName("Bayu Dwiyan Satria Certificate Authorities")
            .setLocalityName("ID")
            .setStateOrProvinceName("East Java")
            .build();

        KeyPair keyPair = new KeyBuilder(Encryption.RSA2048).build();
        Signer signer = new Signer(SignatureAlgorithm.RS512, keyPair.getPrivate());

        CertificateRequest csr = signer.doSign(distinguishedName, keyPair.getPublic());

        System.out.println(csr.print());

        Certificate certificate = signer.doSign(distinguishedName, csr);

        System.out.println(certificate.print());
    }
}
