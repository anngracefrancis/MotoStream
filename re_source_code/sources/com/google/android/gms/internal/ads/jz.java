package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class jz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f12842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f12843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ float f12844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzhd f12845i;

    jz(zzhd zzhdVar, int i2, int i3, float f2) {
        this.f12845i = zzhdVar;
        this.f12842f = i2;
        this.f12843g = i3;
        this.f12844h = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12845i.H.e(this.f12842f, this.f12843g, this.f12844h);
    }
}
