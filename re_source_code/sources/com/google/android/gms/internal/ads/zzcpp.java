package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpp extends zzzd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbjm f15516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcxx f15517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbzc f15518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcpw f15519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbro f15520k;
    private zzbpk l;
    private String m;
    private String n;

    public zzcpp(Context context, zzbjm zzbjmVar, zzcxx zzcxxVar, zzbzc zzbzcVar, zzyz zzyzVar) {
        final zzcpw zzcpwVar = new zzcpw();
        this.f15519j = zzcpwVar;
        this.f15515f = context;
        this.f15516g = zzbjmVar;
        this.f15517h = zzcxxVar;
        this.f15518i = zzbzcVar;
        zzcpwVar.c(zzyzVar);
        final zzaje zzajeVarE = zzbzcVar.e();
        this.f15520k = new zzbro(zzcpwVar, zzajeVarE) { // from class: com.google.android.gms.internal.ads.ym

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcpw f13650f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzaje f13651g;

            {
                this.f13650f = zzcpwVar;
                this.f13651g = zzajeVarE;
            }

            @Override // com.google.android.gms.internal.ads.zzbro
            public final void onAdFailedToLoad(int i2) {
                zzcpw zzcpwVar2 = this.f13650f;
                zzaje zzajeVar = this.f13651g;
                zzcpwVar2.onAdFailedToLoad(i2);
                if (zzajeVar != null) {
                    try {
                        zzajeVar.h3(i2);
                    } catch (RemoteException e2) {
                        zzbad.f("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized void F5(zzxz zzxzVar, int i2) {
        if (this.f15517h.c() == null) {
            zzbad.g("Ad unit ID should not be null for AdLoader.");
            this.f15516g.e().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xm

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzcpp f13583f;

                {
                    this.f13583f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13583f.i7();
                }
            });
            return;
        }
        zzcya.b(this.f15515f, zzxzVar.f16973k);
        this.m = null;
        this.n = null;
        zzcxv zzcxvVarD = this.f15517h.w(zzxzVar).q(i2).d();
        zzbxo zzbxoVarB = this.f15516g.l().c(new zzbqy.zza().e(this.f15515f).b(zzcxvVarD).c()).a(new zzbtv.zza().g(this.f15519j, this.f15516g.e()).d(this.f15520k, this.f15516g.e()).f(this.f15519j, this.f15516g.e()).h(this.f15519j, this.f15516g.e()).c(this.f15519j, this.f15516g.e()).i(zzcxvVarD.n, this.f15516g.e()).k()).d(new zzbxk(this.f15518i, this.f15519j.b())).b();
        zzbxoVarB.f().c(1);
        zzbpk zzbpkVarC = zzbxoVarB.c();
        this.l = zzbpkVarC;
        zzbpkVarC.c(new zm(this, zzbxoVarB));
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized String c0() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized String getMediationAdapterClassName() {
        return this.m;
    }

    final /* synthetic */ void i7() {
        this.f15520k.onAdFailedToLoad(1);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void j2(zzxz zzxzVar) {
        F5(zzxzVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized boolean p0() throws RemoteException {
        zzbpk zzbpkVar;
        zzbpkVar = this.l;
        return zzbpkVar != null && zzbpkVar.a();
    }
}
