package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private k a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f10836b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c7<i> f10838d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b7<byte[]> f10837c = new b7<>(new r1());

    final class a implements y1<i> {
        a() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<i> a(int i2) {
            return new i.a();
        }
    }

    j() {
    }

    private static File e() {
        return new File(b2.d().getPath() + File.separator + "installationNum");
    }

    private static SecretKey f() {
        k0 k0VarA = k0.a();
        d1.c(3, "APIKeyProvider", "Getting legacy apikey: " + k0VarA.f10860c);
        String str = k0VarA.f10860c;
        if (str == null) {
            return null;
        }
        String strA = a2.a(b0.a());
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(TextUtils.isEmpty(strA) ? Long.MIN_VALUE : c2.j(strA)).array(), 1000, 256)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            d1.d(4, "InstallationIdProvider", "Error in generate secret key", e2);
            return null;
        }
    }

    public final void a() {
        if (this.f10838d == null) {
            this.f10838d = new c7<>(e(), "installationNum", 1, new a());
            byte[] bArrC = c(d());
            if (bArrC == null || Build.VERSION.SDK_INT < 23) {
                return;
            }
            b2.e(e());
            b(bArrC, b7.a.CRYPTO_ALGO_PADDING_7);
        }
    }

    final boolean b(byte[] bArr, b7.a aVar) {
        try {
            b2.e(e());
            byte[] bArr2 = new byte[16];
            new SecureRandom().nextBytes(bArr2);
            byte[] bArrB = this.f10837c.b(bArr, d(), new IvParameterSpec(bArr2), aVar);
            this.f10838d.b(bArrB != null ? new i(bArrB, bArr2, true, aVar.ordinal()) : new i(bArr, new byte[0], false, aVar.ordinal()));
            return true;
        } catch (IOException e2) {
            d1.d(5, "InstallationIdProvider", "Error while generating UUID" + e2.getMessage(), e2);
            return false;
        }
    }

    final byte[] c(Key key) {
        byte[] bArrA = null;
        try {
            i iVarA = this.f10838d.a();
            if (iVarA != null) {
                if (iVarA.a) {
                    byte[] bArr = iVarA.f10816b;
                    byte[] bArr2 = iVarA.f10817c;
                    b7.a aVarG = b7.a.g(iVarA.f10818d);
                    if (bArr != null && bArr2 != null) {
                        bArrA = this.f10837c.a(bArr2, key, new IvParameterSpec(bArr), aVarG);
                    }
                } else {
                    bArrA = iVarA.f10817c;
                }
            }
        } catch (IOException unused) {
            d1.c(5, "InstallationIdProvider", "Error while reading Android Install Id. Deleting file.");
        }
        return bArrA;
    }

    final Key d() {
        if (Build.VERSION.SDK_INT < 23) {
            return f();
        }
        if (this.a == null) {
            this.a = new k();
        }
        return this.a.a();
    }
}
