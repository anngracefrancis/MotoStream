package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class zzcoj extends zzamw {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbri f15462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbrt f15463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbse f15464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbso f15465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbtp f15466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbsv f15467k;
    private final zzbvq l;

    public zzcoj(zzbri zzbriVar, zzbrt zzbrtVar, zzbse zzbseVar, zzbso zzbsoVar, zzbtp zzbtpVar, zzbsv zzbsvVar, zzbvq zzbvqVar) {
        this.f15462f = zzbriVar;
        this.f15463g = zzbrtVar;
        this.f15464h = zzbseVar;
        this.f15465i = zzbsoVar;
        this.f15466j = zzbtpVar;
        this.f15467k = zzbsvVar;
        this.l = zzbvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void F0(zzafe zzafeVar, String str) {
    }

    public void I6() throws RemoteException {
    }

    public void R(int i2) throws RemoteException {
    }

    public void b1() {
        this.l.i0();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void k1(zzamy zzamyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void m3(String str) {
    }

    public void n0() {
        this.l.Y();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() {
        this.f15462f.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() {
        this.f15467k.zzsz();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() {
        this.f15463g.Y();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() {
        this.f15464h.f0();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() {
        this.f15465i.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() {
        this.f15467k.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) {
        this.f15466j.onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() {
        this.l.f0();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
        this.l.g0();
    }

    public void t5(zzato zzatoVar) {
    }

    public void v0(zzatq zzatqVar) throws RemoteException {
    }

    public void zzb(Bundle bundle) throws RemoteException {
    }
}
