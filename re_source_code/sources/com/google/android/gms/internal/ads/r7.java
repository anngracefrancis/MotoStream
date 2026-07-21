package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class r7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13264f;

    r7(zzbcd zzbcdVar) {
        this.f13264f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13264f.w != null) {
            this.f13264f.w.c();
        }
    }
}
