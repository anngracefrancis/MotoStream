package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzia implements zzio {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f16299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f16300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f16301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f16302e;

    public zzia(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.a = iArr.length;
        this.f16299b = iArr;
        this.f16300c = jArr;
        this.f16301d = jArr2;
        this.f16302e = jArr3;
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final long a(long j2) {
        return this.f16300c[zzkq.a(this.f16302e, j2, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean b() {
        return true;
    }
}
