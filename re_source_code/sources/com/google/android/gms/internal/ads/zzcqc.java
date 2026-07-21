package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqc implements zzbrl, zzbro, zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzatb f15533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzasu f15534g;

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void a(zzasr zzasrVar, String str, String str2) {
        try {
            zzatb zzatbVar = this.f15533f;
            if (zzatbVar != null) {
                try {
                    zzatbVar.l1(zzasrVar);
                } catch (RemoteException e2) {
                    zzbad.d("Remote Exception at onRewarded.", e2);
                }
            }
            zzasu zzasuVar = this.f15534g;
            if (zzasuVar != null) {
                try {
                    zzasuVar.y3(zzasrVar, str, str2);
                } catch (RemoteException e3) {
                    zzbad.f("#007 Could not call remote method.", e3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(zzasu zzasuVar) {
        this.f15534g = zzasuVar;
    }

    public final synchronized void c(zzatb zzatbVar) {
        this.f15533f = zzatbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdClosed() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdClosed.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i2) {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoAdFailedToLoad(i2);
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdFailedToLoad.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdLeftApplication() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdLeftApplication.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdLoaded.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdOpened() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdOpened.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoCompleted() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoCompleted();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoStarted() {
        zzatb zzatbVar = this.f15533f;
        if (zzatbVar != null) {
            try {
                zzatbVar.onRewardedVideoStarted();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onRewardedVideoStarted.", e2);
            }
        }
    }
}
