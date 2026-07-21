package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class cz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzgv f12441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgr f12442g;

    cz(zzgr zzgrVar, zzgv zzgvVar) {
        this.f12442g = zzgrVar;
        this.f12441f = zzgvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12442g.f16260j.d(this.f12441f);
    }
}
