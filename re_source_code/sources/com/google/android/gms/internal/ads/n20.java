package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class n20 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f13013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f13014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f13016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f13017f;

    public n20(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        zzsk.a(iArr.length == jArr2.length);
        zzsk.a(jArr.length == jArr2.length);
        zzsk.a(iArr2.length == jArr2.length);
        this.f13013b = jArr;
        this.f13014c = iArr;
        this.f13015d = i2;
        this.f13016e = jArr2;
        this.f13017f = iArr2;
        this.a = jArr.length;
    }

    public final int a(long j2) {
        for (int iB = zzsy.b(this.f13016e, j2, true, false); iB >= 0; iB--) {
            if ((this.f13017f[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }

    public final int b(long j2) {
        for (int iK = zzsy.k(this.f13016e, j2, true, false); iK < this.f13016e.length; iK++) {
            if ((this.f13017f[iK] & 1) != 0) {
                return iK;
            }
        }
        return -1;
    }
}
