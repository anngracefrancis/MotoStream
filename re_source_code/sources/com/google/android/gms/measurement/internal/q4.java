package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class q4 extends r4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17912b;

    q4(zzfx zzfxVar) {
        super(zzfxVar);
        this.a.i(this);
    }

    protected void o() {
    }

    protected final void p() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void q() {
        if (this.f17912b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (s()) {
            return;
        }
        this.a.t();
        this.f17912b = true;
    }

    public final void r() {
        if (this.f17912b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        o();
        this.a.t();
        this.f17912b = true;
    }

    protected abstract boolean s();

    final boolean t() {
        return this.f17912b;
    }
}
