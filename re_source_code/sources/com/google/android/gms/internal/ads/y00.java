package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class y00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13592g;

    y00(zzma zzmaVar, zznc zzncVar) {
        this.f13592g = zzmaVar;
        this.f13591f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13591f.a();
        this.f13592g.f16456b.b(this.f13591f);
    }
}
