package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class e extends zzzd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzabl f12490f;

    private e(zzabl zzablVar) {
        this.f12490f = zzablVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void F5(zzxz zzxzVar, int i2) throws RemoteException {
        zzbad.g("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.a.post(new f(this));
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String c0() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void j2(zzxz zzxzVar) throws RemoteException {
        F5(zzxzVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean p0() throws RemoteException {
        return false;
    }
}
