package com.bayudwiyansatria.common.security;

public enum KeyStoreInstance {
    PKCS12("pcks12"),
    JKS("jks");

    private final String instance;

    /**
     * @param instance Key Instance
     */
    KeyStoreInstance(final String instance) {
        this.instance = instance;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return instance;
    }
}
