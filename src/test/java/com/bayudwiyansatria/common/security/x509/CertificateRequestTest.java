package com.bayudwiyansatria.common.security.x509;

import com.bayudwiyansatria.common.security.Encryption;
import com.bayudwiyansatria.common.security.KeyBuilder;
import com.bayudwiyansatria.common.security.SignatureAlgorithm;
import java.security.KeyPair;
import org.junit.Test;

/**
 * Certificate Request Test
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class CertificateRequestTest {

    @Test
    public void generateCertificationRequest() {
        DistinguishedName distinguishedName = new DistinguishedNameBuilder()
            .setCommonName("bayudwiyansatria.com")
            .setOrganizationName("Bayu Dwiyan Satria")
            .setOrganizationalUnitName("Bayu Dwiyan Satria Certificate Authorities")
            .setLocalityName("ID")
            .setStateOrProvinceName("East Java")
            .build();

        KeyPair keyPair = new KeyBuilder(Encryption.RSA2048).build();
        Signer signer = new Signer(SignatureAlgorithm.RS512, keyPair.getPrivate());

        CertificateRequest csr = new CertificateRequestBuilder(signer)
            .setDistinguishedName(distinguishedName)
            .setPublicKey(keyPair.getPublic())
            .build();

        System.out.println(csr.getSubject());
        System.out.println(csr.print());
    }
}
