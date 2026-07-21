package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17829h;

    j4(zzgc zzgcVar, zzan zzanVar, zzm zzmVar) {
        this.f17829h = zzgcVar;
        this.f17827f = zzanVar;
        this.f17828g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzan zzanVarE3 = this.f17829h.E3(this.f17827f, this.f17828g);
        this.f17829h.f18163f.e0();
        this.f17829h.f18163f.p(zzanVarE3, this.f17828g);
    }
}
