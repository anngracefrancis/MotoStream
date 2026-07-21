package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class y4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f18028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18029g;

    y4(zzhc zzhcVar, long j2) {
        this.f18029g = zzhcVar;
        this.f18028f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhc zzhcVar = this.f18029g;
        long j2 = this.f18028f;
        zzhcVar.d();
        zzhcVar.b();
        zzhcVar.x();
        zzhcVar.h().O().a("Resetting analytics data (FE)");
        zzjl zzjlVarU = zzhcVar.u();
        zzjlVarU.d();
        zzjlVarU.f18204e.a();
        if (zzhcVar.n().K(zzhcVar.q().C())) {
            zzhcVar.m().f17927k.b(j2);
        }
        if (!TextUtils.isEmpty(zzhcVar.m().C.a())) {
            zzhcVar.m().C.b(null);
        }
        boolean zP = zzhcVar.a.p();
        if (!zzhcVar.n().I()) {
            zzhcVar.m().D(!zP);
        }
        zzhcVar.r().X();
        zzhcVar.f18181h = !zP;
        this.f18029g.r().S(new AtomicReference<>());
    }
}
