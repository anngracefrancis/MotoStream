package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class y7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcq f13615f;

    y7(zzbcq zzbcqVar) {
        this.f13615f = zzbcqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13615f.x("surfaceCreated", new String[0]);
    }
}
