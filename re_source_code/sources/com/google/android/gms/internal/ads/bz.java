package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class bz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhv f12372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgn f12373g;

    bz(zzgn zzgnVar, zzhv zzhvVar) {
        this.f12373g = zzgnVar;
        this.f12372f = zzhvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12373g.G.h(this.f12372f);
    }
}
