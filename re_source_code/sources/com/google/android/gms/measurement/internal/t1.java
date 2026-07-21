package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f17953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzb f17954h;

    t1(zzb zzbVar, String str, long j2) {
        this.f17954h = zzbVar;
        this.f17952f = str;
        this.f17953g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17954h.F(this.f17952f, this.f17953g);
    }
}
