package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f18004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzkj f18005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzm f18006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzik f18007i;

    w5(zzik zzikVar, boolean z, zzkj zzkjVar, zzm zzmVar) {
        this.f18007i = zzikVar;
        this.f18004f = z;
        this.f18005g = zzkjVar;
        this.f18006h = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f18007i.f18193d;
        if (zzelVar == null) {
            this.f18007i.h().H().a("Discarding data. Failed to set user attribute");
        } else {
            this.f18007i.M(zzelVar, this.f18004f ? null : this.f18005g, this.f18006h);
            this.f18007i.d0();
        }
    }
}
