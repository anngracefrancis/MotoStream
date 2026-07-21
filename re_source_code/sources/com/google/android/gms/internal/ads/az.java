package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class az implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhu f12278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgn f12279g;

    az(zzgn zzgnVar, zzhu zzhuVar) {
        this.f12279g = zzgnVar;
        this.f12278f = zzhuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12279g.G.f(this.f12278f);
    }
}
