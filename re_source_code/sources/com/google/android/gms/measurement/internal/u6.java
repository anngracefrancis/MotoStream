package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjl f17981g;

    u6(zzjl zzjlVar, long j2) {
        this.f17981g = zzjlVar;
        this.f17980f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17981g.J(this.f17980f);
    }
}
