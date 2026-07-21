package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccg extends zzagh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbyn f15054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbyt f15055h;

    public zzccg(String str, zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f15053f = str;
        this.f15054g = zzbynVar;
        this.f15055h = zzbytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void D6() {
        this.f15054g.h();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean E(Bundle bundle) throws RemoteException {
        return this.f15054g.A(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void G0(zzaag zzaagVar) throws RemoteException {
        this.f15054g.l(zzaagVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void L(Bundle bundle) throws RemoteException {
        this.f15054g.z(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void W() throws RemoteException {
        this.f15054g.g();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void d0(zzagd zzagdVar) throws RemoteException {
        this.f15054g.n(zzagdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void destroy() throws RemoteException {
        this.f15054g.a();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void e0(zzaak zzaakVar) throws RemoteException {
        this.f15054g.m(zzaakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaea f() throws RemoteException {
        return this.f15055h.V();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String g() throws RemoteException {
        return this.f15055h.g();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final Bundle getExtras() throws RemoteException {
        return this.f15055h.f();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f15053f;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getStore() throws RemoteException {
        return this.f15055h.l();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaar getVideoController() throws RemoteException {
        return this.f15055h.m();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String h() throws RemoteException {
        return this.f15055h.d();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String i() throws RemoteException {
        return this.f15055h.c();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper j() throws RemoteException {
        return this.f15055h.W();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void j0() {
        this.f15054g.B();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List k() throws RemoteException {
        return this.f15055h.h();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaei n() throws RemoteException {
        return this.f15055h.U();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaee n2() throws RemoteException {
        return this.f15054g.C();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String o() throws RemoteException {
        return this.f15055h.j();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper r() throws RemoteException {
        return ObjectWrapper.E0(this.f15054g);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final double t() throws RemoteException {
        return this.f15055h.k();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean u2() throws RemoteException {
        return (this.f15055h.i().isEmpty() || this.f15055h.y() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List u4() throws RemoteException {
        return u2() ? this.f15055h.i() : Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String w() throws RemoteException {
        return this.f15055h.b();
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void z(Bundle bundle) throws RemoteException {
        this.f15054g.w(bundle);
    }
}
