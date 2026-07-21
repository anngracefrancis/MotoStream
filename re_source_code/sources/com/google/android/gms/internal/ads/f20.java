package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class f20 implements d20 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzst f12555c;

    public f20(a20 a20Var) {
        zzst zzstVar = a20Var.Q0;
        this.f12555c = zzstVar;
        zzstVar.k(12);
        this.a = zzstVar.s();
        this.f12554b = zzstVar.s();
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final boolean a() {
        return this.a != 0;
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final int b() {
        return this.f12554b;
    }

    @Override // com.google.android.gms.internal.ads.d20
    public final int c() {
        int i2 = this.a;
        return i2 == 0 ? this.f12555c.s() : i2;
    }
}
