package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzv f17730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17731g;

    d4(zzgc zzgcVar, zzv zzvVar) {
        this.f17731g = zzgcVar;
        this.f17730f = zzvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17731g.f18163f.e0();
        if (this.f17730f.f18242h.y() == null) {
            this.f17731g.f18163f.Q(this.f17730f);
        } else {
            this.f17731g.f18163f.x(this.f17730f);
        }
    }
}
