package com.bayudwiyansatria.common.security;

import com.bayudwiyansatria.common.security.utils.SecurityUtils;
import java.security.KeyPair;
import java.security.PublicKey;
import org.junit.Test;

public class UtilityTest {

    @Test
    public void generateKeyPairRSA2048() {
        KeyPair keyPair = new KeyBuilder()
            .setProvider(SecurityProvider.BC)
            .build();

        PublicKey publicKey = keyPair.getPublic();
        System.out.println(new SecurityUtils().getMessageDigest(publicKey));
    }
}
