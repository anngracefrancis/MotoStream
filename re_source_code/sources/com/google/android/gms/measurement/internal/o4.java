package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzv f17894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17896h;

    o4(zzgc zzgcVar, zzv zzvVar, zzm zzmVar) {
        this.f17896h = zzgcVar;
        this.f17894f = zzvVar;
        this.f17895g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17896h.f18163f.e0();
        if (this.f17894f.f18242h.y() == null) {
            this.f17896h.f18163f.R(this.f17894f, this.f17895g);
        } else {
            this.f17896h.f18163f.y(this.f17894f, this.f17895g);
        }
    }
}
