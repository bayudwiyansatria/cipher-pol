package com.bayudwiyansatria.common.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class KeyStoreBuilder {

    private KeyStore keyStore;

    private String keyStoreAlias;

    private String keyStoreName;

    private byte[] key;

    private Certificate[] chain;

    private String keyInstance;
    private char[] password;

    public KeyStoreBuilder() {
        this.keyStore = this.build();
        this.keyStoreAlias = "";
        this.key = new byte[]{};
        this.chain = new Certificate[]{};
        this.keyInstance = KeyStore.getDefaultType();
        this.password = "".toCharArray();
    }

    public KeyStoreBuilder(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    public KeyStoreBuilder(KeyStore keyStore, String alias, byte[] key) {
        this.keyStore = keyStore;
        this.keyStoreAlias = alias;
        this.key = key;
        this.chain = new Certificate[]{};
    }

    public KeyStoreBuilder(KeyStore keyStore, String alias, byte[] key, Certificate[] chain) {
        this.keyStore = keyStore;
        this.keyStoreAlias = alias;
        this.key = key;
        this.chain = chain;
    }

    public KeyStoreBuilder(String keyInstance) {
        this.keyInstance = keyInstance;
        this.password = "".toCharArray();
    }

    public KeyStoreBuilder(String keyInstance, String password) {
        this.keyInstance = keyInstance;
        this.password = password.toCharArray();
        this.keyStore = this.build();
    }

    public KeyStore build() {
        try {
            KeyStore keyStore = KeyStore.getInstance(keyInstance);
            keyStore.load(new FileInputStream(keyStoreName + ".jks"), password);

            keyStore.setKeyEntry(keyStoreAlias, key, chain);
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KeyStore build(KeyStoreInstance keyStoreInstance, String keyStoreName) {
        try {
            KeyStore keyStore = KeyStore.getInstance(keyInstance);
            char[] passwordCharArray = password;
            keyStore.load(null, passwordCharArray);
            try (FileOutputStream fileOutputStream = new FileOutputStream(keyStoreName + ".jks")) {
                keyStore.store(fileOutputStream, passwordCharArray;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
