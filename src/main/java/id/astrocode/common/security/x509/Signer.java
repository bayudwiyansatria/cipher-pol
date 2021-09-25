package id.astrocode.common.security.x509;

import id.astrocode.common.security.SignatureAlgorithm;
import id.astrocode.common.security.x509.impl.CertificateImpl;
import id.astrocode.common.security.x509.impl.CertificateRequestImpl;
import id.astrocode.common.security.x509.utils.SerialNumberGenerator;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZonedDateTime;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

/**
 * Signer
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class Signer {

    private final PrivateKey privateKey;
    private ContentSigner signer;

    /**
     * Signer Constructor
     *
     * @param signatureAlgorithm Signature Algorithm
     * @param privateKey         Signer Private Key
     * @see SignatureAlgorithm
     * @since 0.0.1
     */
    Signer(SignatureAlgorithm signatureAlgorithm, PrivateKey privateKey) {
        this.privateKey = privateKey;
        try {
            this.signer = new JcaContentSignerBuilder(signatureAlgorithm.getJcaName())
                .build(privateKey);
        } catch (OperatorCreationException e) {
            e.printStackTrace();
        }
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(
                privateKey.getAlgorithm());
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            return keyFactory.generatePublic(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ContentSigner getContentSigner() {
        return signer;
    }

    /**
     * Sign Certificate Request
     *
     * @param subjectDistinguishedName Subject
     * @param subjectPublicKey         Subject Public Key
     * @return Certificate Request
     * @see CertificateRequest
     * @see DistinguishedName
     * @see PublicKey
     * @since 0.0.1
     */
    public CertificateRequest doSign(
        DistinguishedName subjectDistinguishedName,
        PublicKey subjectPublicKey
    ) {
        return new CertificateRequestImpl(
            new JcaPKCS10CertificationRequestBuilder(subjectDistinguishedName.getX500Name(),
                subjectPublicKey).build(signer));
    }

    /**
     * Sign Certificate
     *
     * @param issuerDistinguishedName Issuer Subject
     * @param certificateRequest      Certificate Request
     * @return Certificate
     * @see Certificate
     * @see DistinguishedName
     * @see CertificateRequest
     * @since 0.0.1
     */
    public Certificate doSign(
        DistinguishedName issuerDistinguishedName,
        CertificateRequest certificateRequest
    ) {
        try {
            X509v3CertificateBuilder certificateBuilder = new X509v3CertificateBuilder(
                issuerDistinguishedName.getX500Name(),
                new SerialNumberGenerator().generateRandomSerialNumber(),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                certificateRequest.getSubject().getX500Name(),
                certificateRequest.getPKCS10CertificationRequest().getSubjectPublicKeyInfo()
            );
            X509CertificateHolder holder = certificateBuilder.build(signer);
            return new CertificateImpl(new JcaX509CertificateConverter().getCertificate(holder));

        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
