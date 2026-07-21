package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class u10 implements s10 {
    private final /* synthetic */ zzod a;

    private u10(zzod zzodVar) {
        this.a = zzodVar;
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final boolean a(int i2) {
        return zzod.m(i2);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void b(int i2, int i3, zzno zznoVar) throws InterruptedException, IOException {
        this.a.f(i2, i3, zznoVar);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void c(int i2, long j2) throws zzlm {
        this.a.p(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void g(int i2, String str) throws zzlm {
        this.a.i(i2, str);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void h(int i2, double d2) throws zzlm {
        this.a.b(i2, d2);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void i(int i2, long j2, long j3) throws zzlm {
        this.a.n(i2, j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final int j(int i2) {
        return zzod.t(i2);
    }

    @Override // com.google.android.gms.internal.ads.s10
    public final void k(int i2) throws zzlm {
        this.a.u(i2);
    }

    /* synthetic */ u10(zzod zzodVar, t10 t10Var) {
        this(zzodVar);
    }
}
