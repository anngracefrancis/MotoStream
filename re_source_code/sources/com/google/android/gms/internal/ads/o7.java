package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class o7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13090f;

    o7(zzbcd zzbcdVar) {
        this.f13090f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13090f.w != null) {
            this.f13090f.w.a();
        }
    }
}
