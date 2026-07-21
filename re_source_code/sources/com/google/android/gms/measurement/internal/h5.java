package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17805g;

    h5(zzhc zzhcVar, boolean z) {
        this.f17805g = zzhcVar;
        this.f17804f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17805g.B0(this.f17804f);
    }
}
