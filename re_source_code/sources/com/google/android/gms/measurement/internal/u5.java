package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzig f17977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzig f17978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzif f17979i;

    u5(zzif zzifVar, boolean z, zzig zzigVar, zzig zzigVar2) {
        this.f17979i = zzifVar;
        this.f17976f = z;
        this.f17977g = zzigVar;
        this.f17978h = zzigVar2;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzif zzifVar;
        zzig zzigVar;
        boolean z2;
        if (this.f17979i.n().T(this.f17979i.q().C())) {
            z = this.f17976f && this.f17979i.f18183c != null;
            if (z) {
                zzif zzifVar2 = this.f17979i;
                zzifVar2.J(zzifVar2.f18183c, true);
            }
        } else {
            if (this.f17976f && (zzigVar = (zzifVar = this.f17979i).f18183c) != null) {
                zzifVar.J(zzigVar, true);
            }
            z = false;
        }
        zzig zzigVar2 = this.f17977g;
        if (zzigVar2 != null) {
            long j2 = zzigVar2.f18190c;
            zzig zzigVar3 = this.f17978h;
            z2 = (j2 == zzigVar3.f18190c && zzkk.t0(zzigVar2.f18189b, zzigVar3.f18189b) && zzkk.t0(this.f17977g.a, this.f17978h.a)) ? false : true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zzif.I(this.f17978h, bundle, true);
            zzig zzigVar4 = this.f17977g;
            if (zzigVar4 != null) {
                String str = zzigVar4.a;
                if (str != null) {
                    bundle.putString("_pn", str);
                }
                bundle.putString("_pc", this.f17977g.f18189b);
                bundle.putLong("_pi", this.f17977g.f18190c);
            }
            if (this.f17979i.n().T(this.f17979i.q().C()) && z) {
                long jE = this.f17979i.u().f18204e.e();
                if (jE > 0) {
                    this.f17979i.l().J(bundle, jE);
                }
            }
            this.f17979i.p().u0("auto", "_vs", bundle);
        }
        zzif zzifVar3 = this.f17979i;
        zzifVar3.f18183c = this.f17978h;
        zzifVar3.r().N(this.f17978h);
    }
}
