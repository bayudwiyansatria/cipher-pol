package com.bayudwiyansatria.common.security.key.rsa;

import com.bayudwiyansatria.common.security.KeyBuilder;
import com.bayudwiyansatria.common.security.SecurityProvider;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RSABuilderTest {

    List<SecurityProvider> provider = new ArrayList<>() {
        {
            add(SecurityProvider.BC);
        }
    };
    int[] keySize = new int[]{
        2048,
        4096
    };

    @Test
    public void generateRSAKeyPair() {
        for (SecurityProvider securityProvider : provider) {
            for (int k : keySize) {
                KeyPair keyPair = new KeyBuilder()
                    .setProvider(securityProvider)
                    .setSize(k)
                    .build();

                System.out.println(keyPair.getPrivate());
                System.out.println(keyPair.getPublic());
            }
        }
    }
}
