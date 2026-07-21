package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class a5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzgx f17694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17695g;

    a5(zzhc zzhcVar, zzgx zzgxVar) {
        this.f17695g = zzhcVar;
        this.f17694f = zzgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17695g.J(this.f17694f);
    }
}
