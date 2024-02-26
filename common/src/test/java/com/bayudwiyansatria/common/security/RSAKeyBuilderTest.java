package com.bayudwiyansatria.common.security;

import java.security.KeyPair;
import org.junit.Assert;
import org.junit.Test;

public class RSAKeyBuilderTest {

    private KeyPair keyPair;

    @Test
    public void BuildKeyRSA() {
        this.keyPair = new KeyBuilder().build();
        Assert.assertNotNull(keyPair);
    }

    @Test
    public void BuildKeyRSA2048() {
        this.keyPair = new KeyBuilder()
            .setProvider(SecurityProvider.BC)
            .setEncryption(Encryption.RSA)
            .setSize(2048)
            .build();
        Assert.assertNotNull(keyPair);
    }

    @Test
    public void BuildKeyRSA4098() {
        this.keyPair = new KeyBuilder()
            .setProvider(SecurityProvider.BC)
            .setEncryption(Encryption.RSA)
            .setSize(4098)
            .build();
        Assert.assertNotNull(keyPair);
    }
}
