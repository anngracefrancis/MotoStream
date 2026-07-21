package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbz extends zzaex {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbyn f15031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbyt f15032h;

    public zzcbz(String str, zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f15030f = str;
        this.f15031g = zzbynVar;
        this.f15032h = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean E(Bundle bundle) throws RemoteException {
        return this.f15031g.A(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void L(Bundle bundle) throws RemoteException {
        this.f15031g.z(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() throws RemoteException {
        this.f15031g.a();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaea f() throws RemoteException {
        return this.f15032h.V();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String g() throws RemoteException {
        return this.f15032h.g();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() throws RemoteException {
        return this.f15032h.f();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f15030f;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() throws RemoteException {
        return this.f15032h.l();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaar getVideoController() throws RemoteException {
        return this.f15032h.m();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String h() throws RemoteException {
        return this.f15032h.d();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String i() throws RemoteException {
        return this.f15032h.c();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper j() throws RemoteException {
        return this.f15032h.W();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List k() throws RemoteException {
        return this.f15032h.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaei n() throws RemoteException {
        return this.f15032h.U();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String o() throws RemoteException {
        return this.f15032h.j();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper r() throws RemoteException {
        return ObjectWrapper.E0(this.f15031g);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double t() throws RemoteException {
        return this.f15032h.k();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void z(Bundle bundle) throws RemoteException {
        this.f15031g.w(bundle);
    }
}
