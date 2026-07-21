package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnl implements zzcjv<zzcdb> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcdn f15442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcdf f15443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcxv f15444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f15445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbai f15446f;

    public zzcnl(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor, zzcdf zzcdfVar, zzcdn zzcdnVar) {
        this.a = context;
        this.f15444d = zzcxvVar;
        this.f15443c = zzcdfVar;
        this.f15445e = executor;
        this.f15446f = zzbaiVar;
        this.f15442b = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzcdb> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzced zzcedVar = new zzced();
        zzbbh<zzcdb> zzbbhVarC = zzbar.c(zzbar.o(null), new zzbal(this, zzcxmVar, zzcedVar, zzcxuVar) { // from class: com.google.android.gms.internal.ads.ul
            private final zzcnl a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzcxm f13402b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzced f13403c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final zzcxu f13404d;

            {
                this.a = this;
                this.f13402b = zzcxmVar;
                this.f13403c = zzcedVar;
                this.f13404d = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f13402b, this.f13403c, this.f13404d, obj);
            }
        }, this.f15445e);
        zzbbhVarC.k(vl.a(zzcedVar), this.f15445e);
        return zzbbhVarC;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar = zzcxmVar.p;
        return (zzcxqVar == null || zzcxqVar.a == null) ? false : true;
    }

    final /* synthetic */ zzbbh c(final zzcxm zzcxmVar, zzced zzcedVar, zzcxu zzcxuVar, Object obj) throws Exception {
        final zzbgz zzbgzVarB = this.f15442b.b(this.f15444d.f15751e);
        zzbgzVarB.x(zzcxmVar.M);
        zzcedVar.a(this.a, zzbgzVarB.getView());
        final zzbbr zzbbrVar = new zzbbr();
        final zzcdc zzcdcVarA = this.f15443c.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzcdd(new zzbwz(this, zzbgzVarB, zzcxmVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.yl
            private final zzcnl a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzbgz f13647b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzcxm f13648c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final zzbbr f13649d;

            {
                this.a = this;
                this.f13647b = zzbgzVarB;
                this.f13648c = zzcxmVar;
                this.f13649d = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                this.a.d(this.f13647b, this.f13648c, this.f13649d, z, context);
            }
        }, zzbgzVarB));
        zzbbrVar.a(zzcdcVarA);
        zzahx.b(zzbgzVarB, zzcdcVarA.k());
        zzbrt zzbrtVarD = zzcdcVarA.d();
        zzbrw zzbrwVar = new zzbrw(zzbgzVarB) { // from class: com.google.android.gms.internal.ads.zl

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f13716f;

            {
                this.f13716f = zzbgzVarB;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f13716f;
                if (zzbgzVar.p() != null) {
                    zzbgzVar.p().e();
                }
            }
        };
        Executor executor = zzbbm.f14331b;
        zzbrtVarD.V(zzbrwVar, executor);
        zzcdcVarA.g().i(zzbgzVarB, true);
        zzcdcVarA.g();
        zzcxq zzcxqVar = zzcxmVar.p;
        zzbbh<?> zzbbhVarA = zzcdp.a(zzbgzVarB, zzcxqVar.f15741b, zzcxqVar.a);
        if (zzcxmVar.E) {
            zzbbhVarA.k(new Runnable(zzbgzVarB) { // from class: com.google.android.gms.internal.ads.am

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbgz f12260f;

                {
                    this.f12260f = zzbgzVarB;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12260f.l0();
                }
            }, this.f15445e);
        }
        zzbbhVarA.k(new Runnable(zzbgzVarB) { // from class: com.google.android.gms.internal.ads.bm

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f12355f;

            {
                this.f12355f = zzbgzVarB;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12355f.O();
            }
        }, this.f15445e);
        return zzbar.d(zzbbhVarA, new zzbam(zzcdcVarA) { // from class: com.google.android.gms.internal.ads.cm
            private final zzcdc a;

            {
                this.a = zzcdcVarA;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj2) {
                return this.a.j();
            }
        }, executor);
    }

    final /* synthetic */ void d(zzbgz zzbgzVar, zzcxm zzcxmVar, zzbbr zzbbrVar, boolean z, Context context) {
        zzbgz zzbgzVar2;
        try {
            zzcdc zzcdcVar = (zzcdc) zzbbrVar.get();
            if (zzbgzVar.p0()) {
                if (((Boolean) zzyt.e().c(zzacu.X0)).booleanValue()) {
                    final zzbgz zzbgzVarB = this.f15442b.b(this.f15444d.f15751e);
                    zzahx.b(zzbgzVarB, zzcdcVar.k());
                    final zzced zzcedVar = new zzced();
                    zzcedVar.a(this.a, zzbgzVarB.getView());
                    zzcdcVar.g().i(zzbgzVarB, true);
                    zzbgzVarB.p().i(new zzbij(zzcedVar, zzbgzVarB) { // from class: com.google.android.gms.internal.ads.wl
                        private final zzced a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        private final zzbgz f13515b;

                        {
                            this.a = zzcedVar;
                            this.f13515b = zzbgzVarB;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbij
                        public final void zzae(boolean z2) {
                            zzced zzcedVar2 = this.a;
                            zzbgz zzbgzVar3 = this.f13515b;
                            zzcedVar2.b();
                            zzbgzVar3.O();
                            zzbgzVar3.p().e();
                        }
                    });
                    zzbgzVarB.p().j(xl.b(zzbgzVarB));
                    zzcxq zzcxqVar = zzcxmVar.p;
                    zzbgzVarB.G(zzcxqVar.f15741b, zzcxqVar.a, null);
                    zzbgzVar2 = zzbgzVarB;
                }
                zzbgzVar2.j0(true);
                zzk.zzlg();
                com.google.android.gms.ads.internal.zzh zzhVar = new com.google.android.gms.ads.internal.zzh(false, zzaxi.H(this.a), false, 0.0f, -1, z, zzcxmVar.F, zzcxmVar.G);
                zzk.zzlf();
                com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).i(), null, zzbgzVar2, zzcxmVar.H, this.f15446f, zzcxmVar.y, zzhVar), true);
            }
            zzbgzVar2 = zzbgzVar;
            zzbgzVar2.j0(true);
            zzk.zzlg();
            com.google.android.gms.ads.internal.zzh zzhVar2 = new com.google.android.gms.ads.internal.zzh(false, zzaxi.H(this.a), false, 0.0f, -1, z, zzcxmVar.F, zzcxmVar.G);
            zzk.zzlf();
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).i(), null, zzbgzVar2, zzcxmVar.H, this.f15446f, zzcxmVar.y, zzhVar2), true);
        } catch (Exception unused) {
        }
    }
}
