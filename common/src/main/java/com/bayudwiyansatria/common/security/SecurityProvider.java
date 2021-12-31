package com.bayudwiyansatria.common.security;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Security Provider
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public enum SecurityProvider {
    /**
     * Bounce Castle Provider
     */
    BC(BouncyCastleProvider.PROVIDER_NAME);

    private final String provider;

    SecurityProvider(String provider) {
        Security.addProvider(new BouncyCastleProvider());
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }
}
