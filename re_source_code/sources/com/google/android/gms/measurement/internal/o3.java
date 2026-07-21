package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p3 f17893g;

    o3(p3 p3Var, boolean z) {
        this.f17893g = p3Var;
        this.f17892f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17893g.f17899b.B(this.f17892f);
    }
}
