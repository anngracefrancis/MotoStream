package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqa implements zzbrl, zzbrs {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzatw f15530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzaue f15531g;

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final synchronized void R(int i2) {
        zzatw zzatwVar = this.f15530f;
        if (zzatwVar != null) {
            try {
                zzatwVar.p6(i2);
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void a(zzasr zzasrVar, String str, String str2) {
        zzaue zzaueVar;
        zzatw zzatwVar = this.f15530f;
        if (zzatwVar == null) {
            zzaueVar = this.f15531g;
            if (zzaueVar != null) {
                zzaueVar.X2(new zzaup(zzasrVar.getType(), zzasrVar.getAmount()), str, str2);
                return;
            }
            return;
        }
        try {
            zzatwVar.v0(new zzaup(zzasrVar.getType(), zzasrVar.getAmount()));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
        zzaueVar = this.f15531g;
        if (zzaueVar != null) {
            try {
                zzaueVar.X2(new zzaup(zzasrVar.getType(), zzasrVar.getAmount()), str, str2);
                return;
            } catch (RemoteException e3) {
                zzbad.f("#007 Could not call remote method.", e3);
                return;
            }
        }
        return;
        throw th;
    }

    public final synchronized void b(zzatw zzatwVar) {
        this.f15530f = zzatwVar;
    }

    public final synchronized void c(zzaue zzaueVar) {
        this.f15531g = zzaueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdClosed() {
        zzatw zzatwVar = this.f15530f;
        if (zzatwVar != null) {
            try {
                zzatwVar.o1();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdOpened() {
        zzatw zzatwVar = this.f15530f;
        if (zzatwVar != null) {
            try {
                zzatwVar.S1();
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoStarted() {
    }
}
