package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class b40 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f12311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f12312g;

    b40(zzto zztoVar, zznc zzncVar) {
        this.f12312g = zztoVar;
        this.f12311f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12311f.a();
        this.f12312g.f16775b.p(this.f12311f);
    }
}
