package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzkj f17838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17840h;

    k4(zzgc zzgcVar, zzkj zzkjVar, zzm zzmVar) {
        this.f17840h = zzgcVar;
        this.f17838f = zzkjVar;
        this.f17839g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17840h.f18163f.e0();
        if (this.f17838f.y() == null) {
            this.f17840h.f18163f.O(this.f17838f, this.f17839g);
        } else {
            this.f17840h.f18163f.v(this.f17838f, this.f17839g);
        }
    }
}
