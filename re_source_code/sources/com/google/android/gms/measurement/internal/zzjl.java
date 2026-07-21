package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjl extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f18202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a7 f18203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected y6 f18204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private x6 f18205f;

    zzjl(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18203d = new a7(this);
        this.f18204e = new y6(this);
        this.f18205f = new x6(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j2) {
        d();
        H();
        h().P().b("Activity resumed, time", Long.valueOf(j2));
        this.f18205f.a(j2);
        this.f18204e.b(j2);
        this.f18203d.a(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        d();
        if (this.f18202c == null) {
            this.f18202c = new zzj(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(long j2) {
        d();
        H();
        h().P().b("Activity paused, time", Long.valueOf(j2));
        this.f18205f.b(j2);
        this.f18204e.f(j2);
        a7 a7Var = this.f18203d;
        if (a7Var.f17699b.n().B(a7Var.f17699b.q().C(), zzap.c0)) {
            a7Var.f17699b.m().z.a(true);
        }
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    public final boolean E(boolean z, boolean z2) {
        return this.f18204e.d(z, z2);
    }

    protected final void F() {
        g().z(new v6(this, j().b()));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }
}
