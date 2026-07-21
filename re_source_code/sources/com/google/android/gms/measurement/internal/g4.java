package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17770g;

    g4(zzgc zzgcVar, zzm zzmVar) {
        this.f17770g = zzgcVar;
        this.f17769f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17770g.f18163f.e0();
        this.f17770g.f18163f.w(this.f17769f);
    }
}
