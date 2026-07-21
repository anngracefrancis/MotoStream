package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class w00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzlh f13486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13487g;

    w00(zzma zzmaVar, zzlh zzlhVar) {
        this.f13487g = zzmaVar;
        this.f13486f = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13487g.f16456b.f(this.f13486f);
    }
}
