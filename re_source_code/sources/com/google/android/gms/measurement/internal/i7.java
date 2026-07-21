package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class i7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzkh f17825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzkc f17826g;

    i7(zzkc zzkcVar, zzkh zzkhVar) {
        this.f17826g = zzkcVar;
        this.f17825f = zzkhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17826g.u(this.f17825f);
        this.f17826g.i();
    }
}
