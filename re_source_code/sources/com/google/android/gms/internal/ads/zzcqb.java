package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqb implements zzbro, zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzaub f15532f;

    public final synchronized void a(zzaub zzaubVar) {
        this.f15532f = zzaubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i2) {
        zzaub zzaubVar = this.f15532f;
        if (zzaubVar != null) {
            try {
                zzaubVar.R4(i2);
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        zzaub zzaubVar = this.f15532f;
        if (zzaubVar != null) {
            try {
                zzaubVar.n1();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }
}
