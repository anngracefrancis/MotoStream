package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class m4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17867g;

    m4(zzgc zzgcVar, zzm zzmVar) {
        this.f17867g = zzgcVar;
        this.f17866f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17867g.f18163f.e0();
        this.f17867g.f18163f.P(this.f17866f);
    }
}
