package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class u00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13375g;

    u00(zzma zzmaVar, zznc zzncVar) {
        this.f13375g = zzmaVar;
        this.f13374f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13375g.f16456b.e(this.f13374f);
    }
}
