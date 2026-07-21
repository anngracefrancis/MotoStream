package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class lz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f12943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzhd f12945h;

    lz(zzhd zzhdVar, int i2, long j2) {
        this.f12945h = zzhdVar;
        this.f12943f = i2;
        this.f12944g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12945h.H.b(this.f12943f, this.f12944g);
    }
}
