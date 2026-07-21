package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcla extends zzamw implements zzbsm {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzamv f15356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbsn f15357g;

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void F0(zzafe zzafeVar, String str) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.F0(zzafeVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void I6() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.I6();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void R(int i2) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.R(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void b1() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.b1();
        }
    }

    public final synchronized void i7(zzamv zzamvVar) {
        this.f15356f = zzamvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void k1(zzamy zzamyVar) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.k1(zzamyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void m3(String str) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.m3(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void n0() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.n0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void n6(zzbsn zzbsnVar) {
        this.f15357g = zzbsnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdClicked() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdClosed() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdFailedToLoad(int i2) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdFailedToLoad(i2);
        }
        zzbsn zzbsnVar = this.f15357g;
        if (zzbsnVar != null) {
            zzbsnVar.onAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdImpression() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdLeftApplication() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdLoaded() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdLoaded();
        }
        zzbsn zzbsnVar = this.f15357g;
        if (zzbsnVar != null) {
            zzbsnVar.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdOpened() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onVideoPause() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onVideoPlay() throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void t5(zzato zzatoVar) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.t5(zzatoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void v0(zzatq zzatqVar) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.v0(zzatqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzamv zzamvVar = this.f15356f;
        if (zzamvVar != null) {
            zzamvVar.zzb(bundle);
        }
    }
}
