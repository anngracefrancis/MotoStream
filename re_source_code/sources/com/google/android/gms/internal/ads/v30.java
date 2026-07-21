package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class v30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f13438g;

    v30(zzto zztoVar, zznc zzncVar) {
        this.f13438g = zztoVar;
        this.f13437f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13438g.f16775b.r(this.f13437f);
    }
}
