package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class x00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzma f13540i;

    x00(zzma zzmaVar, int i2, long j2, long j3) {
        this.f13540i = zzmaVar;
        this.f13537f = i2;
        this.f13538g = j2;
        this.f13539h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13540i.f16456b.c(this.f13537f, this.f13538g, this.f13539h);
    }
}
