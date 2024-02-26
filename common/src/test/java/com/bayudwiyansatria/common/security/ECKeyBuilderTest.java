package com.bayudwiyansatria.common.security;

import java.security.KeyPair;
import org.junit.Assert;
import org.junit.Test;

public class ECKeyBuilderTest {

    private KeyPair keyPair;

    @Test
    public void BuildKeyECC256() {
        this.keyPair = new KeyBuilder()
            .setProvider(SecurityProvider.BC)
            .setEncryption(Encryption.EC)
            .setSize(256)
            .build();
        Assert.assertNotNull(keyPair);
    }

}
