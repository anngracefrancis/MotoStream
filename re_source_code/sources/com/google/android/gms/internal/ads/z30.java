package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class z30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f13675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f13676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ float f13677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzto f13678j;

    z30(zzto zztoVar, int i2, int i3, int i4, float f2) {
        this.f13678j = zztoVar;
        this.f13674f = i2;
        this.f13675g = i3;
        this.f13676h = i4;
        this.f13677i = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13678j.f16775b.m(this.f13674f, this.f13675g, this.f13676h, this.f13677i);
    }
}
