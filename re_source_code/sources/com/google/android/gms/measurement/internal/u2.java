package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class u2 extends k3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17972b;

    u2(zzfx zzfxVar) {
        super(zzfxVar);
        this.a.d(this);
    }

    protected abstract boolean A();

    protected void v() {
    }

    final boolean w() {
        return this.f17972b;
    }

    protected final void x() {
        if (!w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void y() {
        if (this.f17972b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (A()) {
            return;
        }
        this.a.t();
        this.f17972b = true;
    }

    public final void z() {
        if (this.f17972b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        v();
        this.a.t();
        this.f17972b = true;
    }
}
