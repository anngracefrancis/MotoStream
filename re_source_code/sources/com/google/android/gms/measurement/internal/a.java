package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f17692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzb f17693h;

    a(zzb zzbVar, String str, long j2) {
        this.f17693h = zzbVar;
        this.f17691f = str;
        this.f17692g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17693h.E(this.f17691f, this.f17692g);
    }
}
