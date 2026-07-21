package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzanp extends zzamw {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Adapter f14011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzatk f14012g;

    zzanp(Adapter adapter, zzatk zzatkVar) {
        this.f14011f = adapter;
        this.f14012g = zzatkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void F0(zzafe zzafeVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void I6() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.b5(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void R(int i2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void b1() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.a2(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void k1(zzamy zzamyVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void m3(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void n0() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.G6(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.Y5(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i2) throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.q2(ObjectWrapper.E0(this.f14011f), i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.w3(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.f1(ObjectWrapper.E0(this.f14011f));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void t5(zzato zzatoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void v0(zzatq zzatqVar) throws RemoteException {
        zzatk zzatkVar = this.f14012g;
        if (zzatkVar != null) {
            zzatkVar.Y3(ObjectWrapper.E0(this.f14011f), new zzato(zzatqVar.getType(), zzatqVar.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
    }
}
