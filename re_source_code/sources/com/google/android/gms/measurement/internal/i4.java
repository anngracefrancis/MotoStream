package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class i4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17816h;

    i4(zzgc zzgcVar, zzan zzanVar, String str) {
        this.f17816h = zzgcVar;
        this.f17814f = zzanVar;
        this.f17815g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17816h.f18163f.e0();
        this.f17816h.f18163f.q(this.f17814f, this.f17815g);
    }
}
