package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzel f17889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjc f17890g;

    n6(zzjc zzjcVar, zzel zzelVar) {
        this.f17890g = zzjcVar;
        this.f17889f = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17890g) {
            zzjc.c(this.f17890g, false);
            if (!this.f17890g.f18201h.V()) {
                this.f17890g.f18201h.h().O().a("Connected to remote service");
                this.f17890g.f18201h.L(this.f17889f);
            }
        }
    }
}
