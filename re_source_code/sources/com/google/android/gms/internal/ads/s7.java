package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class s7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f13317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13318h;

    s7(zzbcd zzbcdVar, int i2, int i3) {
        this.f13318h = zzbcdVar;
        this.f13316f = i2;
        this.f13317g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13318h.w != null) {
            this.f13318h.w.d(this.f13316f, this.f13317g);
        }
    }
}
