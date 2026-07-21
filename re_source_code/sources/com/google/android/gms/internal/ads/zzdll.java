package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdll implements zzdby {
    private Mac a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Key f15977d;

    public zzdll(String str, Key key, int i2) throws GeneralSecurityException {
        if (i2 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                if (i2 > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case "HMACSHA256":
                if (i2 > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case "HMACSHA512":
                if (i2 > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                throw new NoSuchAlgorithmException(str.length() != 0 ? "unknown Hmac algorithm: ".concat(str) : new String("unknown Hmac algorithm: "));
        }
        this.f15976c = str;
        this.f15975b = i2;
        this.f15977d = key;
        Mac macB = zzdkx.f15961d.b(str);
        this.a = macB;
        macB.init(key);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        Mac macB;
        try {
            macB = (Mac) this.a.clone();
        } catch (CloneNotSupportedException unused) {
            macB = zzdkx.f15961d.b(this.f15976c);
            macB.init(this.f15977d);
        }
        macB.update(bArr);
        byte[] bArr2 = new byte[this.f15975b];
        System.arraycopy(macB.doFinal(), 0, bArr2, 0, this.f15975b);
        return bArr2;
    }
}
