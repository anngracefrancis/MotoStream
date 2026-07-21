package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzkc f17949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Runnable f17950g;

    s6(zzji zzjiVar, zzkc zzkcVar, Runnable runnable) {
        this.f17949f = zzkcVar;
        this.f17950g = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17949f.e0();
        this.f17949f.z(this.f17950g);
        this.f17949f.d0();
    }
}
