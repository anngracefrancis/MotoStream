package com.google.android.gms.stats;

/* JADX INFO: loaded from: classes2.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ WakeLock f18309f;

    b(WakeLock wakeLock) {
        this.f18309f = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18309f.f(0);
    }
}
