package id.astrocode.common.security;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.junit.Test;

public class KeyGenerator {

    @Test
    public void generateKeyPair() {
        KeyPair keyPair = new KeyBuilder()
            .setEncryption(Encryption.RSA)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }
}
