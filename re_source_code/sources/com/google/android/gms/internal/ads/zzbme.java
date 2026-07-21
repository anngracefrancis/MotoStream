package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbme implements zzbrl, zzbrw, zzbsr, zzxr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcxu f14530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzcxm f14531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdae f14532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14534j;

    public zzbme(zzcxu zzcxuVar, zzcxm zzcxmVar, zzdae zzdaeVar) {
        this.f14530f = zzcxuVar;
        this.f14531g = zzcxmVar;
        this.f14532h = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void a(zzasr zzasrVar, String str, String str2) {
        zzdae zzdaeVar = this.f14532h;
        zzcxu zzcxuVar = this.f14530f;
        zzcxm zzcxmVar = this.f14531g;
        zzdaeVar.b(zzcxuVar, zzcxmVar, zzcxmVar.f15730h, zzasrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdClicked() {
        zzdae zzdaeVar = this.f14532h;
        zzcxu zzcxuVar = this.f14530f;
        zzcxm zzcxmVar = this.f14531g;
        zzdaeVar.a(zzcxuVar, zzcxmVar, zzcxmVar.f15725c);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (!this.f14534j) {
            zzdae zzdaeVar = this.f14532h;
            zzcxu zzcxuVar = this.f14530f;
            zzcxm zzcxmVar = this.f14531g;
            zzdaeVar.a(zzcxuVar, zzcxmVar, zzcxmVar.f15726d);
            this.f14534j = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f14533i) {
            ArrayList arrayList = new ArrayList(this.f14531g.f15726d);
            arrayList.addAll(this.f14531g.f15728f);
            this.f14532h.c(this.f14530f, this.f14531g, true, arrayList);
        } else {
            zzdae zzdaeVar = this.f14532h;
            zzcxu zzcxuVar = this.f14530f;
            zzcxm zzcxmVar = this.f14531g;
            zzdaeVar.a(zzcxuVar, zzcxmVar, zzcxmVar.m);
            zzdae zzdaeVar2 = this.f14532h;
            zzcxu zzcxuVar2 = this.f14530f;
            zzcxm zzcxmVar2 = this.f14531g;
            zzdaeVar2.a(zzcxuVar2, zzcxmVar2, zzcxmVar2.f15728f);
        }
        this.f14533i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
        zzdae zzdaeVar = this.f14532h;
        zzcxu zzcxuVar = this.f14530f;
        zzcxm zzcxmVar = this.f14531g;
        zzdaeVar.a(zzcxuVar, zzcxmVar, zzcxmVar.f15731i);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
        zzdae zzdaeVar = this.f14532h;
        zzcxu zzcxuVar = this.f14530f;
        zzcxm zzcxmVar = this.f14531g;
        zzdaeVar.a(zzcxuVar, zzcxmVar, zzcxmVar.f15729g);
    }
}
