package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ik implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbgz f12774f;

    private ik(zzbgz zzbgzVar) {
        this.f12774f = zzbgzVar;
    }

    static Runnable a(zzbgz zzbgzVar) {
        return new ik(zzbgzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12774f.l0();
    }
}
