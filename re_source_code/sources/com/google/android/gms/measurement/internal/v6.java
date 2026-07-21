package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjl f17997g;

    v6(zzjl zzjlVar, long j2) {
        this.f17997g = zzjlVar;
        this.f17996f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17997g.B(this.f17996f);
    }
}
