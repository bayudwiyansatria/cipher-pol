package id.astrocode.common.security;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.junit.Test;

/**
 * Key Generator
 *
 * @author Bayu Dwiyan Satria
 */
public class KeyGeneratorTest {

    @Test
    public void generateKeyPairRSA2048() {
        KeyPair keyPair = new KeyBuilder(Encryption.RSA2048)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }

    @Test
    public void generateKeyPairRSA4096() {
        KeyPair keyPair = new KeyBuilder(Encryption.RSA4096)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }

    @Test
    public void generateKeyPairEC256() {
        KeyPair keyPair = new KeyBuilder(Encryption.EC256)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }

    @Test
    public void generateKeyPairEC512() {
        KeyPair keyPair = new KeyBuilder(Encryption.EC512)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }
}
