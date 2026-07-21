package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class m6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzel f17870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjc f17871g;

    m6(zzjc zzjcVar, zzel zzelVar) {
        this.f17871g = zzjcVar;
        this.f17870f = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17871g) {
            zzjc.c(this.f17871g, false);
            if (!this.f17871g.f18201h.V()) {
                this.f17871g.f18201h.h().P().a("Connected to service");
                this.f17871g.f18201h.L(this.f17870f);
            }
        }
    }
}
