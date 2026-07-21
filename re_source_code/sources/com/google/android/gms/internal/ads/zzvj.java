package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzvj extends zzva {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MessageDigest f16848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16850e;

    public zzvj(int i2) {
        int i3 = i2 / 8;
        this.f16849d = i2 % 8 > 0 ? i3 + 1 : i3;
        this.f16850e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final byte[] a(String str) {
        synchronized (this.f16841b) {
            MessageDigest messageDigestB = b();
            this.f16848c = messageDigestB;
            if (messageDigestB == null) {
                return new byte[0];
            }
            messageDigestB.reset();
            this.f16848c.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = this.f16848c.digest();
            int length = bArrDigest.length;
            int length2 = this.f16849d;
            if (length <= length2) {
                length2 = bArrDigest.length;
            }
            byte[] bArr = new byte[length2];
            System.arraycopy(bArrDigest, 0, bArr, 0, length2);
            if (this.f16850e % 8 > 0) {
                long j2 = 0;
                for (int i2 = 0; i2 < length2; i2++) {
                    if (i2 > 0) {
                        j2 <<= 8;
                    }
                    j2 += (long) (bArr[i2] & 255);
                }
                long j3 = j2 >>> (8 - (this.f16850e % 8));
                for (int i3 = this.f16849d - 1; i3 >= 0; i3--) {
                    bArr[i3] = (byte) (255 & j3);
                    j3 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
