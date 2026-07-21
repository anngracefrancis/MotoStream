package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class f7 extends h7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17765c;

    f7(zzkc zzkcVar) {
        super(zzkcVar);
        this.f17811b.s(this);
    }

    final boolean s() {
        return this.f17765c;
    }

    protected final void t() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u() {
        if (this.f17765c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        v();
        this.f17811b.f0();
        this.f17765c = true;
    }

    protected abstract boolean v();
}
