package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zztg {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16762b;

    private zztg(List<byte[]> list, int i2) {
        this.a = list;
        this.f16762b = i2;
    }

    public static zztg a(zzst zzstVar) throws zzlm {
        try {
            zzstVar.l(21);
            int iG = zzstVar.g() & 3;
            int iG2 = zzstVar.g();
            int iB = zzstVar.b();
            int i2 = 0;
            for (int i3 = 0; i3 < iG2; i3++) {
                zzstVar.l(1);
                int iH = zzstVar.h();
                for (int i4 = 0; i4 < iH; i4++) {
                    int iH2 = zzstVar.h();
                    i2 += iH2 + 4;
                    zzstVar.l(iH2);
                }
            }
            zzstVar.k(iB);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < iG2; i6++) {
                zzstVar.l(1);
                int iH3 = zzstVar.h();
                for (int i7 = 0; i7 < iH3; i7++) {
                    int iH4 = zzstVar.h();
                    byte[] bArr2 = zzsq.a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(zzstVar.a, zzstVar.b(), bArr, length, iH4);
                    i5 = length + iH4;
                    zzstVar.l(iH4);
                }
            }
            return new zztg(i2 == 0 ? null : Collections.singletonList(bArr), iG + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzlm("Error parsing HEVC config", e2);
        }
    }
}
