package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccb extends zzafb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbyn f15042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbyt f15043h;

    public zzccb(String str, zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f15041f = str;
        this.f15042g = zzbynVar;
        this.f15043h = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaei D0() throws RemoteException {
        return this.f15043h.X();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean E(Bundle bundle) throws RemoteException {
        return this.f15042g.A(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void L(Bundle bundle) throws RemoteException {
        this.f15042g.z(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void destroy() throws RemoteException {
        this.f15042g.a();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaea f() throws RemoteException {
        return this.f15043h.V();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String g() throws RemoteException {
        return this.f15043h.g();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final Bundle getExtras() throws RemoteException {
        return this.f15043h.f();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f15041f;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaar getVideoController() throws RemoteException {
        return this.f15043h.m();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String h() throws RemoteException {
        return this.f15043h.d();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String i() throws RemoteException {
        return this.f15043h.c();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper j() throws RemoteException {
        return this.f15043h.W();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final List k() throws RemoteException {
        return this.f15043h.h();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper r() throws RemoteException {
        return ObjectWrapper.E0(this.f15042g);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String w() throws RemoteException {
        return this.f15043h.b();
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void z(Bundle bundle) throws RemoteException {
        this.f15042g.w(bundle);
    }
}
