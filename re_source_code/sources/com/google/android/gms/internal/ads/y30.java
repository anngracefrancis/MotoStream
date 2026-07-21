package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class y30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzto f13608h;

    y30(zzto zztoVar, int i2, long j2) {
        this.f13608h = zztoVar;
        this.f13606f = i2;
        this.f13607g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13608h.f16775b.b(this.f13606f, this.f13607g);
    }
}
