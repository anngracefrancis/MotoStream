package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class d0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c0 f11748f;

    d0(c0 c0Var) {
        this.f11748f = c0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11748f.a.f11724g.disconnect();
    }
}
