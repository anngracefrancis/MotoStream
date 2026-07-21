package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
class r4 implements s4 {
    protected final zzfx a;

    r4(zzfx zzfxVar) {
        Preconditions.k(zzfxVar);
        this.a = zzfxVar;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public zzw G() {
        return this.a.G();
    }

    public void a() {
        this.a.s();
    }

    public void b() {
        this.a.r();
    }

    public void c() {
        this.a.g().c();
    }

    public void d() {
        this.a.g().d();
    }

    public zzah e() {
        return this.a.S();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public Context f() {
        return this.a.f();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public zzfu g() {
        return this.a.g();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public zzet h() {
        return this.a.h();
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public Clock j() {
        return this.a.j();
    }

    public zzer k() {
        return this.a.J();
    }

    public zzkk l() {
        return this.a.I();
    }

    public r3 m() {
        return this.a.B();
    }

    public zzx n() {
        return this.a.y();
    }
}
