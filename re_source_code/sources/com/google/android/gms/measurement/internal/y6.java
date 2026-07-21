package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class y6 {

    @VisibleForTesting
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private long f18032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f18033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzjl f18034d;

    public y6(zzjl zzjlVar) {
        this.f18034d = zzjlVar;
        this.f18033c = new b7(this, zzjlVar.a);
        long jB = zzjlVar.j().b();
        this.a = jB;
        this.f18032b = jB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.f18034d.d();
        d(false, false);
        this.f18034d.o().v(this.f18034d.j().b());
    }

    final void a() {
        this.f18033c.e();
        this.a = 0L;
        this.f18032b = 0L;
    }

    final void b(long j2) {
        this.f18034d.d();
        this.f18033c.e();
        this.a = j2;
        this.f18032b = j2;
    }

    public final boolean d(boolean z, boolean z2) {
        this.f18034d.d();
        this.f18034d.x();
        long jB = this.f18034d.j().b();
        this.f18034d.m().w.b(this.f18034d.j().a());
        long j2 = jB - this.a;
        if (!z && j2 < 1000) {
            this.f18034d.h().P().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        this.f18034d.m().x.b(j2);
        this.f18034d.h().P().b("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        zzif.I(this.f18034d.s().L(), bundle, true);
        if (this.f18034d.n().T(this.f18034d.q().C())) {
            if (this.f18034d.n().B(this.f18034d.q().C(), zzap.j0)) {
                if (!z2) {
                    e();
                }
            } else if (z2) {
                bundle.putLong("_fr", 1L);
            } else {
                e();
            }
        }
        if (!this.f18034d.n().B(this.f18034d.q().C(), zzap.j0) || !z2) {
            this.f18034d.p().S("auto", "_e", bundle);
        }
        this.a = jB;
        this.f18033c.e();
        this.f18033c.c(Math.max(0L, 3600000 - this.f18034d.m().x.a()));
        return true;
    }

    @VisibleForTesting
    final long e() {
        long jB = this.f18034d.j().b();
        long j2 = jB - this.f18032b;
        this.f18032b = jB;
        return j2;
    }

    final void f(long j2) {
        this.f18033c.e();
        if (this.a != 0) {
            this.f18034d.m().x.b(this.f18034d.m().x.a() + (j2 - this.a));
        }
    }
}
