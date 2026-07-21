package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ s4 f17766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ f f17767g;

    g(f fVar, s4 s4Var) {
        this.f17767g = fVar;
        this.f17766f = s4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17766f.G();
        if (zzw.a()) {
            this.f17766f.g().z(this);
            return;
        }
        boolean zD = this.f17767g.d();
        f.a(this.f17767g, 0L);
        if (zD) {
            this.f17767g.b();
        }
    }
}
