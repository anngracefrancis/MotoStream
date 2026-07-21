package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzic implements zzip {
    private final rz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzhm f16306b = new zzhm(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16307c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16308d = Long.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16309e = Long.MIN_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f16310f = Long.MIN_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile zzhj f16311g;

    public zzic(zzjl zzjlVar) {
        this.a = new rz(zzjlVar);
    }

    private final boolean m() {
        boolean zF = this.a.f(this.f16306b);
        if (this.f16307c) {
            while (zF && !this.f16306b.b()) {
                this.a.j();
                zF = this.a.f(this.f16306b);
            }
        }
        if (!zF) {
            return false;
        }
        long j2 = this.f16309e;
        return j2 == Long.MIN_VALUE || this.f16306b.f16282e < j2;
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final int a(zzie zzieVar, int i2) throws InterruptedException, IOException {
        return this.a.d(zzieVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final void b(zzhj zzhjVar) {
        this.f16311g = zzhjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final void c(zzkm zzkmVar, int i2) {
        this.a.e(zzkmVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public void d(long j2, int i2, int i3, int i4, byte[] bArr) {
        this.f16310f = Math.max(this.f16310f, j2);
        rz rzVar = this.a;
        rzVar.b(j2, i2, (rzVar.k() - ((long) i3)) - ((long) i4), i3, bArr);
    }

    public final void e() {
        this.a.a();
        this.f16307c = true;
        this.f16308d = Long.MIN_VALUE;
        this.f16309e = Long.MIN_VALUE;
        this.f16310f = Long.MIN_VALUE;
    }

    public final boolean f() {
        return !m();
    }

    public final boolean g(zzhm zzhmVar) {
        if (!m()) {
            return false;
        }
        this.a.g(zzhmVar);
        this.f16307c = false;
        this.f16308d = zzhmVar.f16282e;
        return true;
    }

    public final void h(long j2) {
        while (this.a.f(this.f16306b) && this.f16306b.f16282e < j2) {
            this.a.j();
            this.f16307c = true;
        }
        this.f16308d = Long.MIN_VALUE;
    }

    public final boolean i(long j2) {
        return this.a.h(j2);
    }

    public final boolean j() {
        return this.f16311g != null;
    }

    public final zzhj k() {
        return this.f16311g;
    }

    public final long l() {
        return this.f16310f;
    }
}
