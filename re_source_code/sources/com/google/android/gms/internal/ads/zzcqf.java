package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqf extends zzatu {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbbh<zzcdb> f15541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzcdb f15542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbjm f15543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f15544i;
    private zzbss m;
    private final String n;
    private final zzcxx p;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcqa f15545j = new zzcqa();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcqb f15546k = new zzcqb();
    private final zzcpz l = new zzcpz();
    private boolean o = false;

    public zzcqf(zzbjm zzbjmVar, Context context, String str) {
        zzcxx zzcxxVar = new zzcxx();
        zzcxxVar.p.add("new_rewarded");
        this.p = zzcxxVar;
        this.f15543h = zzbjmVar;
        this.f15544i = context;
        this.n = str;
    }

    static /* synthetic */ zzbbh i7(zzcqf zzcqfVar, zzbbh zzbbhVar) {
        zzcqfVar.f15541f = null;
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void G5(zzaao zzaaoVar) throws RemoteException {
        this.l.a(new en(this, zzaaoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void K2(zzaue zzaueVar) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.f15545j.c(zzaueVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void L5(zzatw zzatwVar) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.f15545j.b(zzatwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final zzatq O6() {
        zzcdb zzcdbVar;
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (!this.o || (zzcdbVar = this.f15542g) == null) {
            return null;
        }
        return zzcdbVar.j();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void W1(zzxz zzxzVar, zzaub zzaubVar) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.f15546k.a(zzaubVar);
        this.o = false;
        if (this.f15541f != null) {
            return;
        }
        if (this.f15542g != null) {
            return;
        }
        zzcya.b(this.f15544i, zzxzVar.f16973k);
        zzcdf zzcdfVarB = this.f15543h.m().a(new zzbqy.zza().e(this.f15544i).b(this.p.t(this.n).n(zzyd.e0()).w(zzxzVar).d()).c()).c(new zzbtv.zza().c(this.f15545j, this.f15543h.e()).g(new fn(this, this.f15546k), this.f15543h.e()).d(this.f15546k, this.f15543h.e()).e(this.f15545j, this.f15543h.e()).b(this.l, this.f15543h.e()).a(new zzcpy(), this.f15543h.e()).k()).b();
        this.m = zzcdfVarB.d();
        zzbbh<zzcdb> zzbbhVarC = zzcdfVarB.c();
        this.f15541f = zzbbhVarC;
        zzbar.f(zzbbhVarC, new dn(this, zzcdfVarB), this.f15543h.e());
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void e7(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (this.f15542g == null) {
            zzbad.i("Rewarded can not be shown before loaded");
            this.f15545j.R(2);
        } else {
            this.f15542g.i(z, (Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void f5(IObjectWrapper iObjectWrapper) throws RemoteException {
        e7(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        zzbss zzbssVar;
        Preconditions.f("#008 Must be called on the main UI thread.");
        return (!this.o || (zzbssVar = this.m) == null) ? new Bundle() : zzbssVar.Y();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzcdb zzcdbVar = this.f15542g;
        if (zzcdbVar == null) {
            return null;
        }
        return zzcdbVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        return this.o;
    }

    final void l7() {
        this.o = true;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final synchronized void m2(zzaum zzaumVar) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.p.u(zzaumVar.f14162f);
        if (((Boolean) zzyt.e().c(zzacu.d1)).booleanValue()) {
            this.p.v(zzaumVar.f14163g);
        }
    }

    final void m7() {
        this.l.onAdMetadataChanged();
    }
}
