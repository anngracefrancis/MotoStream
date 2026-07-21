package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class e30 implements zzqw {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ x20 f12504b;

    public e30(x20 x20Var, int i2) {
        this.f12504b = x20Var;
        this.a = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final boolean B() {
        return this.f12504b.v(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void a() throws IOException {
        this.f12504b.H();
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void b(long j2) {
        this.f12504b.C(this.a, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final int c(zzlj zzljVar, zznd zzndVar, boolean z) {
        return this.f12504b.q(this.a, zzljVar, zzndVar, z);
    }
}
