package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v7 extends w7 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbj.zze f17998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q7 f17999h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v7(q7 q7Var, String str, int i2, zzbj.zze zzeVar) {
        super(str, i2);
        this.f17999h = q7Var;
        this.f17998g = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.w7
    final int a() {
        return this.f17998g.E();
    }

    final boolean i(Long l, zzbr.zzk zzkVar, boolean z) {
        boolean zY = this.f17999h.n().y(this.a, zzap.w0);
        boolean zY2 = this.f17999h.n().y(this.a, zzap.C0);
        boolean zH = this.f17998g.H();
        boolean zI = this.f17998g.I();
        boolean z2 = zY && this.f17998g.K();
        boolean z3 = zH || zI || z2;
        Boolean boolD = null;
        boolD = null;
        boolD = null;
        boolD = null;
        boolD = null;
        if (z && !z3) {
            this.f17999h.h().P().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f18009b), this.f17998g.D() ? Integer.valueOf(this.f17998g.E()) : null);
            return true;
        }
        zzbj.zzc zzcVarG = this.f17998g.G();
        boolean zI2 = zzcVarG.I();
        if (zzkVar.T()) {
            if (zzcVarG.F()) {
                boolD = w7.d(w7.c(zzkVar.U(), zzcVarG.G()), zI2);
            } else {
                this.f17999h.h().K().b("No number filter for long property. property", this.f17999h.k().B(zzkVar.P()));
            }
        } else if (zzkVar.V()) {
            if (zzcVarG.F()) {
                boolD = w7.d(w7.b(zzkVar.W(), zzcVarG.G()), zI2);
            } else {
                this.f17999h.h().K().b("No number filter for double property. property", this.f17999h.k().B(zzkVar.P()));
            }
        } else if (!zzkVar.R()) {
            this.f17999h.h().K().b("User property has no value, property", this.f17999h.k().B(zzkVar.P()));
        } else if (zzcVarG.D()) {
            boolD = w7.d(w7.g(zzkVar.S(), zzcVarG.E(), this.f17999h.h()), zI2);
        } else if (!zzcVarG.F()) {
            this.f17999h.h().K().b("No string or number filter defined. property", this.f17999h.k().B(zzkVar.P()));
        } else if (zzkg.S(zzkVar.S())) {
            boolD = w7.d(w7.e(zzkVar.S(), zzcVarG.G()), zI2);
        } else {
            this.f17999h.h().K().c("Invalid user property value for Numeric number filter. property, value", this.f17999h.k().B(zzkVar.P()), zzkVar.S());
        }
        this.f17999h.h().P().b("Property filter result", boolD == null ? "null" : boolD);
        if (boolD == null) {
            return false;
        }
        this.f18010c = Boolean.TRUE;
        if (zY && z2 && !boolD.booleanValue()) {
            return true;
        }
        if (!z || this.f17998g.H()) {
            this.f18011d = boolD;
        }
        if (boolD.booleanValue() && z3 && zzkVar.I()) {
            long J = zzkVar.J();
            if (zY2 && l != null) {
                J = l.longValue();
            }
            if (zI) {
                this.f18013f = Long.valueOf(J);
            } else {
                this.f18012e = Long.valueOf(J);
            }
        }
        return true;
    }
}
