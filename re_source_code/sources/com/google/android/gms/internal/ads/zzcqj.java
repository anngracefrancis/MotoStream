package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqj extends zzasx {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbbh<zzcdb> f15547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzcdb f15548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbjm f15549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f15550i;
    private zzbss m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcqc f15551j = new zzcqc();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcpx f15552k = new zzcpx();
    private final zzcpy l = new zzcpy();
    private boolean n = false;
    private final zzcxx o = new zzcxx();
    private boolean p = false;

    public zzcqj(zzbjm zzbjmVar, Context context) {
        this.f15549h = zzbjmVar;
        this.f15550i = context;
    }

    static /* synthetic */ zzbbh i7(zzcqj zzcqjVar, zzbbh zzbbhVar) {
        zzcqjVar.f15547f = null;
        return null;
    }

    private final synchronized boolean l7() {
        zzcdb zzcdbVar;
        zzcdbVar = this.f15548g;
        return (zzcdbVar == null || zzcdbVar.g()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void M6(IObjectWrapper iObjectWrapper) {
        Preconditions.f("pause must be called on the main UI thread.");
        if (this.f15548g != null) {
            this.f15548g.h().f0(iObjectWrapper == null ? null : (Context) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void T4(zzasu zzasuVar) {
        Preconditions.f("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.f15551j.b(zzasuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void T5(IObjectWrapper iObjectWrapper) {
        Preconditions.f("resume must be called on the main UI thread.");
        if (this.f15548g != null) {
            this.f15548g.h().g0(iObjectWrapper == null ? null : (Context) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void d2(IObjectWrapper iObjectWrapper) {
        Preconditions.f("destroy must be called on the main UI thread.");
        Context context = null;
        this.f15552k.a(null);
        this.n = false;
        if (this.f15548g != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.k0(iObjectWrapper);
            }
            this.f15548g.h().i0(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void destroy() throws RemoteException {
        d2(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void g5(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() {
        zzbss zzbssVar;
        Preconditions.f("getAdMetadata can only be called from the UI thread.");
        return (!this.n || (zzbssVar = this.m) == null) ? new Bundle() : zzbssVar.Y();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzcdb zzcdbVar = this.f15548g;
        if (zzcdbVar == null) {
            return null;
        }
        return zzcdbVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void h0(zzatb zzatbVar) throws RemoteException {
        Preconditions.f("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f15551j.c(zzatbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void i4(zzath zzathVar) throws RemoteException {
        Preconditions.f("loadAd must be called on the main UI thread.");
        this.n = false;
        String str = zzathVar.f14151g;
        if (str == null) {
            zzbad.g("Ad unit ID should not be null for rewarded video ad.");
            this.f15549h.e().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.gn

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzcqj f12655f;

                {
                    this.f12655f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12655f.o7();
                }
            });
            return;
        }
        if (zzacw.a(str)) {
            return;
        }
        if (this.f15547f != null) {
            return;
        }
        if (l7()) {
            if (!((Boolean) zzyt.e().c(zzacu.o4)).booleanValue()) {
                return;
            }
        }
        zzcya.b(this.f15550i, zzathVar.f14150f.f16973k);
        this.f15548g = null;
        zzcdf zzcdfVarB = this.f15549h.m().a(new zzbqy.zza().e(this.f15550i).b(this.o.t(zzathVar.f14151g).n(zzyd.e0()).w(zzathVar.f14150f).d()).i(null).c()).c(new zzbtv.zza().c(this.f15551j, this.f15549h.e()).g(new jn(this, this.f15551j), this.f15549h.e()).d(this.f15551j, this.f15549h.e()).b(this.f15552k, this.f15549h.e()).a(this.l, this.f15549h.e()).k()).b();
        this.m = zzcdfVarB.d();
        zzbbh<zzcdb> zzbbhVarC = zzcdfVarB.c();
        this.f15547f = zzbbhVarC;
        zzbar.f(zzbbhVarC, new hn(this, zzcdfVarB), this.f15549h.e());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        Preconditions.f("isLoaded must be called on the main UI thread.");
        return l7();
    }

    final void m7() {
        this.n = true;
    }

    final void n7() {
        this.f15552k.onAdMetadataChanged();
    }

    final /* synthetic */ void o7() {
        this.f15551j.onAdFailedToLoad(1);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void pause() throws RemoteException {
        M6(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void resume() throws RemoteException {
        T5(null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void s0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.f("showAd must be called on the main UI thread.");
        if (this.f15548g == null) {
            return;
        }
        if (iObjectWrapper != null) {
            Object objK0 = ObjectWrapper.k0(iObjectWrapper);
            if (objK0 instanceof Activity) {
                activity = (Activity) objK0;
            } else {
                activity = null;
            }
        } else {
            activity = null;
        }
        this.f15548g.i(this.p, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzyt.e().c(zzacu.d1)).booleanValue()) {
            Preconditions.f("#008 Must be called on the main UI thread.: setCustomData");
            this.o.v(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.f("setImmersiveMode must be called on the main UI thread.");
        this.p = z;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.f("setUserId must be called on the main UI thread.");
        this.o.u(str);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void show() throws RemoteException {
        s0(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void z0(zzzp zzzpVar) {
        Preconditions.f("setAdMetadataListener can only be called from the UI thread.");
        this.f15552k.a(new in(this, zzzpVar));
    }
}
