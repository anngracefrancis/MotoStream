package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class g20 implements d20 {
    private final zzst a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12620e;

    public g20(a20 a20Var) {
        zzst zzstVar = a20Var.Q0;
        this.a = zzstVar;
        zzstVar.k(12);
        this.f12618c = zzstVar.s() & 255;
        this.f12617b = zzstVar.s();
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final boolean a() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final int b() {
        return this.f12617b;
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final int c() {
        int i2 = this.f12618c;
        if (i2 == 8) {
            return this.a.g();
        }
        if (i2 == 16) {
            return this.a.h();
        }
        int i3 = this.f12619d;
        this.f12619d = i3 + 1;
        if (i3 % 2 != 0) {
            return this.f12620e & 15;
        }
        int iG = this.a.g();
        this.f12620e = iG;
        return (iG & 240) >> 4;
    }
}
