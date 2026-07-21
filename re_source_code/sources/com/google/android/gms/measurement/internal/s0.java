package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzb f17945g;

    s0(zzb zzbVar, long j2) {
        this.f17945g = zzbVar;
        this.f17944f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17945g.B(this.f17944f);
    }
}
