package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class s0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ r0 f11790f;

    s0(r0 r0Var) {
        this.f11790f = r0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11790f.r.lock();
        try {
            this.f11790f.y();
        } finally {
            this.f11790f.r.unlock();
        }
    }
}
