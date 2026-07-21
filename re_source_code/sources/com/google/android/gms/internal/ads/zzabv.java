package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzabv extends zzatu {
    @Override // com.google.android.gms.internal.ads.zzatt
    public final void G5(zzaao zzaaoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void K2(zzaue zzaueVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void L5(zzatw zzatwVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final zzatq O6() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void W1(zzxz zzxzVar, final zzaub zzaubVar) throws RemoteException {
        zzbad.g("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.a.post(new Runnable(zzaubVar) { // from class: com.google.android.gms.internal.ads.i

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzaub f12726f;

            {
                this.f12726f = zzaubVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaub zzaubVar2 = this.f12726f;
                if (zzaubVar2 != null) {
                    try {
                        zzaubVar2.R4(1);
                    } catch (RemoteException e2) {
                        zzbad.f("#007 Could not call remote method.", e2);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void e7(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void f5(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final String getMediationAdapterClassName() throws RemoteException {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void m2(zzaum zzaumVar) {
    }
}
