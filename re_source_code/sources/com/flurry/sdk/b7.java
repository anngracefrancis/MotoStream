package com.flurry.sdk;

import android.annotation.SuppressLint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class b7<ObjectType> {
    private v1<ObjectType> a;

    public enum a {
        NONE(HttpUrl.FRAGMENT_ENCODE_SET),
        CRYPTO_ALGO_PADDING_7("AES/CBC/PKCS7Padding"),
        CRYPTO_ALGO_PADDING_5("AES/CBC/PKCS5Padding");


        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f10651j;

        a(String str) {
            this.f10651j = str;
        }

        public static a g(int i2) {
            for (a aVar : values()) {
                if (aVar.ordinal() == i2) {
                    return aVar;
                }
            }
            return NONE;
        }
    }

    public b7(v1<ObjectType> v1Var) {
        this.a = v1Var;
    }

    public final ObjectType a(byte[] bArr, Key key, IvParameterSpec ivParameterSpec, a aVar) throws IOException {
        if (bArr == null || key == null || aVar == null) {
            d1.c(5, "FlurryCrypto", "Cannot decrypt, invalid params.");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(aVar.f10651j);
            cipher.init(2, key, ivParameterSpec);
            return this.a.b(new ByteArrayInputStream(cipher.doFinal(bArr)));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            d1.c(5, "FlurryCrypto", "Error in decrypt " + e2.getMessage());
            return null;
        }
    }

    @SuppressLint({"TrulyRandom"})
    public final byte[] b(ObjectType objecttype, Key key, IvParameterSpec ivParameterSpec, a aVar) throws IOException {
        if (objecttype == null || key == null || aVar == null) {
            d1.c(5, "FlurryCrypto", "Cannot encrypt, invalid params.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a.a(byteArrayOutputStream, objecttype);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            Cipher cipher = Cipher.getInstance(aVar.f10651j);
            cipher.init(1, key, ivParameterSpec);
            return cipher.doFinal(byteArray);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            d1.c(5, "FlurryCrypto", "Error in encrypt " + e2.getMessage());
            return null;
        }
    }
}
