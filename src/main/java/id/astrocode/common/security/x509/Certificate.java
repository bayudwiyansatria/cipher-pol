package id.astrocode.common.security.x509;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class Certificate {

    private X509Certificate certificate;
    private PrivateKey privateKey;

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

}
