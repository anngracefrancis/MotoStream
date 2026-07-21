package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzb extends k3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f18081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f18082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f18083d;

    public zzb(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18082c = new c.e.a();
        this.f18081b = new c.e.a();
    }

    private final void A(String str, long j2, zzig zzigVar) {
        if (zzigVar == null) {
            h().P().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j2 < 1000) {
            h().P().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j2);
        zzif.I(zzigVar, bundle, true);
        p().S("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j2) {
        Iterator<String> it = this.f18081b.keySet().iterator();
        while (it.hasNext()) {
            this.f18081b.put(it.next(), Long.valueOf(j2));
        }
        if (this.f18081b.isEmpty()) {
            return;
        }
        this.f18083d = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String str, long j2) {
        b();
        d();
        Preconditions.g(str);
        if (this.f18082c.isEmpty()) {
            this.f18083d = j2;
        }
        Integer num = this.f18082c.get(str);
        if (num != null) {
            this.f18082c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f18082c.size() >= 100) {
            h().K().a("Too many ads visible");
        } else {
            this.f18082c.put(str, 1);
            this.f18081b.put(str, Long.valueOf(j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String str, long j2) {
        b();
        d();
        Preconditions.g(str);
        Integer num = this.f18082c.get(str);
        if (num == null) {
            h().H().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzig zzigVarL = s().L();
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            this.f18082c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        this.f18082c.remove(str);
        Long l = this.f18081b.get(str);
        if (l == null) {
            h().H().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j2 - l.longValue();
            this.f18081b.remove(str);
            A(str, jLongValue, zzigVarL);
        }
        if (this.f18082c.isEmpty()) {
            long j3 = this.f18083d;
            if (j3 == 0) {
                h().H().a("First ad exposure time was never set");
            } else {
                w(j2 - j3, zzigVarL);
                this.f18083d = 0L;
            }
        }
    }

    private final void w(long j2, zzig zzigVar) {
        if (zzigVar == null) {
            h().P().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j2 < 1000) {
            h().P().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j2);
        zzif.I(zzigVar, bundle, true);
        p().S("am", "_xa", bundle);
    }

    public final void D(String str, long j2) {
        if (str == null || str.length() == 0) {
            h().H().a("Ad unit id must be a non-empty string");
        } else {
            g().z(new t1(this, str, j2));
        }
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

    public final void v(long j2) {
        zzig zzigVarL = s().L();
        for (String str : this.f18081b.keySet()) {
            A(str, j2 - this.f18081b.get(str).longValue(), zzigVarL);
        }
        if (!this.f18081b.isEmpty()) {
            w(j2 - this.f18083d, zzigVarL);
        }
        B(j2);
    }

    public final void z(String str, long j2) {
        if (str == null || str.length() == 0) {
            h().H().a("Ad unit id must be a non-empty string");
        } else {
            g().z(new a(this, str, j2));
        }
    }
}
