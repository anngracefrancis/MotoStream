package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17831g;

    j5(zzhc zzhcVar, long j2) {
        this.f17831g = zzhcVar;
        this.f17830f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17831g.m().q.b(this.f17830f);
        this.f17831g.h().O().b("Minimum session duration set", Long.valueOf(this.f17830f));
    }
}
