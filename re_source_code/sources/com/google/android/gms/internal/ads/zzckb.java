package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckb implements zzcjv<zzbnf> {
    private final zzboc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcdn f15316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcxv f15317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f15318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbam<zzcxm, zzayb> f15319f;

    public zzckb(zzboc zzbocVar, Context context, Executor executor, zzcdn zzcdnVar, zzcxv zzcxvVar, zzbam<zzcxm, zzayb> zzbamVar) {
        this.f15315b = context;
        this.a = zzbocVar;
        this.f15318e = executor;
        this.f15316c = zzcdnVar;
        this.f15317d = zzcxvVar;
        this.f15319f = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        return zzbar.c(zzbar.o(null), new zzbal(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.fk
            private final zzckb a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzcxu f12593b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzcxm f12594c;

            {
                this.a = this;
                this.f12593b = zzcxuVar;
                this.f12594c = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f12593b, this.f12594c, obj);
            }
        }, this.f15318e);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar = zzcxmVar.p;
        return (zzcxqVar == null || zzcxqVar.a == null) ? false : true;
    }

    final /* synthetic */ zzbbh c(zzcxu zzcxuVar, zzcxm zzcxmVar, Object obj) throws Exception {
        zzyd zzydVarA = zzcxy.a(this.f15315b, zzcxmVar.r);
        final zzbgz zzbgzVarB = this.f15316c.b(zzydVarA);
        zzbgzVarB.x(zzcxmVar.M);
        final zzbng zzbngVarA = this.a.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbnk(new zzcec(this.f15315b, zzbgzVarB.getView(), this.f15319f.a(zzcxmVar)), zzbgzVarB, gk.a(zzbgzVarB), zzydVarA.n ? new zzcxn(-3, 0, true) : new zzcxn(zzydVarA.f16991j, zzydVarA.f16988g, false)));
        zzbngVarA.h().i(zzbgzVarB, false);
        zzbrt zzbrtVarD = zzbngVarA.d();
        zzbrw zzbrwVar = new zzbrw(zzbgzVarB) { // from class: com.google.android.gms.internal.ads.hk

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f12716f;

            {
                this.f12716f = zzbgzVarB;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f12716f;
                if (zzbgzVar.p() != null) {
                    zzbgzVar.p().e();
                }
            }
        };
        Executor executor = zzbbm.f14331b;
        zzbrtVarD.V(zzbrwVar, executor);
        zzbngVarA.h();
        zzcxq zzcxqVar = zzcxmVar.p;
        zzbbh<?> zzbbhVarA = zzcdp.a(zzbgzVarB, zzcxqVar.f15741b, zzcxqVar.a);
        if (zzcxmVar.E) {
            zzbbhVarA.k(ik.a(zzbgzVarB), this.f15318e);
        }
        zzbbhVarA.k(new Runnable(this, zzbgzVarB) { // from class: com.google.android.gms.internal.ads.jk

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzckb f12829f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbgz f12830g;

            {
                this.f12829f = this;
                this.f12830g = zzbgzVarB;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12829f.d(this.f12830g);
            }
        }, this.f15318e);
        return zzbar.d(zzbbhVarA, new zzbam(zzbngVarA) { // from class: com.google.android.gms.internal.ads.kk
            private final zzbng a;

            {
                this.a = zzbngVarA;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj2) {
                return this.a.g();
            }
        }, executor);
    }

    final /* synthetic */ void d(zzbgz zzbgzVar) {
        zzbgzVar.O();
        zzbhq zzbhqVarH = zzbgzVar.h();
        zzacd zzacdVar = this.f15317d.f15748b;
        if (zzacdVar == null || zzbhqVarH == null) {
            return;
        }
        zzbhqVarH.m7(zzacdVar);
    }
}
