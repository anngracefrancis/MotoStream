package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzabx extends zzasx {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzatb f13781f;

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void M6(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void T4(zzasu zzasuVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void T5(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void d2(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void g5(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void h0(zzatb zzatbVar) throws RemoteException {
        this.f13781f = zzatbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void i4(zzath zzathVar) throws RemoteException {
        zzbad.g("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.a.post(new j(this));
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void s0(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setCustomData(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void z0(zzzp zzzpVar) throws RemoteException {
    }
}
