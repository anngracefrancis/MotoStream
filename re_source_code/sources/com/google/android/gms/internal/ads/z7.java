package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class z7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcq f13687f;

    z7(zzbcq zzbcqVar) {
        this.f13687f = zzbcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13687f.x("surfaceDestroyed", new String[0]);
    }
}
