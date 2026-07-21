package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class z00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13669g;

    z00(zzma zzmaVar, int i2) {
        this.f13669g = zzmaVar;
        this.f13668f = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13669g.f16456b.a(this.f13668f);
    }
}
