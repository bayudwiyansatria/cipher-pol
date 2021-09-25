package id.astrocode.common.security.x509;

import id.astrocode.common.security.x509.impl.CertificateImpl;
import id.astrocode.common.security.x509.utils.SerialNumberGenerator;
import java.security.cert.CertificateException;
import java.time.ZonedDateTime;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;

public class CertificateBuilder {

    private final Signer signer;
    private final CertificateRequest certificateRequest;
    private Certificate certificateAuthority;

    public CertificateBuilder(Signer signer, CertificateRequest certificateRequest) {
        this.signer = signer;
        this.certificateRequest = certificateRequest;
    }

    public CertificateBuilder(Signer signer, CertificateRequest certificateRequest,
        Certificate certificateAuthority) {
        this.signer = signer;
        this.certificateRequest = certificateRequest;
        this.certificateAuthority = certificateAuthority;
    }

    public CertificateBuilder setKeyUsages(KeyUsages[] keyUsages) {
        return this;
    }

    public Certificate build() {
        if (certificateAuthority == null) {
            return this.build(certificateRequest.getSubject());
        } else {
            return this.build(certificateAuthority.getSubject());
        }
    }

    private Certificate build(DistinguishedName issuerDistinguishedName) {
        try {
            X509v3CertificateBuilder certificateBuilder = new X509v3CertificateBuilder(
                issuerDistinguishedName.getX500Name(),
                new SerialNumberGenerator().generateRandomSerialNumber(),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                Date.from(ZonedDateTime.now().plusYears(1).toInstant()),
                certificateRequest.getSubject().getX500Name(),
                certificateRequest.getPKCS10CertificationRequest().getSubjectPublicKeyInfo()
            );
            X509CertificateHolder holder = certificateBuilder.build(this.signer.getContentSigner());
            return new CertificateImpl(new JcaX509CertificateConverter().getCertificate(holder));

        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
