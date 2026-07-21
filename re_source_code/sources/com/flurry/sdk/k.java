package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private KeyStore a;

    @TargetApi(23)
    k() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.a = keyStore;
            keyStore.load(null);
            KeyStore keyStore2 = this.a;
            if (keyStore2 == null || keyStore2.containsAlias("fl.install.id.sec.key")) {
                return;
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder("fl.install.id.sec.key", 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setDigests("SHA-256", "SHA-512").build());
            keyGenerator.generateKey();
        } catch (IOException e2) {
            e = e2;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (NullPointerException e3) {
            e = e3;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e4) {
            e = e4;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (KeyStoreException e5) {
            e = e5;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (NoSuchProviderException e7) {
            e = e7;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (CertificateException e8) {
            e = e8;
            d1.d(5, "KeystoreProvider", "Error while generating Key" + e.getMessage(), e);
        } catch (Exception e9) {
            d1.d(5, "KeystoreProvider", "Unknown Error while generating Key" + e9.getMessage(), e9);
        }
    }

    public final Key a() {
        KeyStore keyStore;
        if (Build.VERSION.SDK_INT < 23 || (keyStore = this.a) == null) {
            return null;
        }
        try {
            return keyStore.getKey("fl.install.id.sec.key", null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException unused) {
            d1.c(6, "KeystoreProvider", "Error in getting key.");
            return null;
        }
    }
}
