package id.astrocode.common.security;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Key Generator
 *
 * @author Bayu Dwiyan Satria
 */
public class KeyGenerator {

    /**
     * Generate RSA KeyPair
     */
    @Test
    public void generateKeyPairRSA2048() {
        KeyPair keyPair = new KeyBuilder()
            .setEncryption(Encryption.RSA2048)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);

        Assert.assertEquals(publicKey, new KeyBuilder().setEncryption(Encryption.RSA2048).build(privateKey).getPublic());
    }

    @Test
    public void generateKeyPairRSA4096() {
        KeyPair keyPair = new KeyBuilder()
            .setEncryption(Encryption.RSA4096)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);

        Assert.assertEquals(publicKey, new KeyBuilder().setEncryption(Encryption.RSA4096).build(privateKey).getPublic());
    }

    @Test
    public void generateKeyPairEC256() {
        KeyPair keyPair = new KeyBuilder()
            .setEncryption(Encryption.EC256)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }

    @Test
    public void generateKeyPairEC512() {
        KeyPair keyPair = new KeyBuilder()
            .setEncryption(Encryption.EC512)
            .setProvider(SecurityProvider.SUN)
            .build();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("PrivateKey : " + privateKey);
        System.out.println("PublicKey : " + publicKey);
    }
}
