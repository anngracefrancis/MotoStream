package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zznl implements zznu {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f16513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f16514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f16515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f16516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16517f;

    public zznl(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f16513b = iArr;
        this.f16514c = jArr;
        this.f16515d = jArr2;
        this.f16516e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f16517f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f16517f = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long a(long j2) {
        return this.f16514c[zzsy.b(this.f16516e, j2, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long f() {
        return this.f16517f;
    }
}
