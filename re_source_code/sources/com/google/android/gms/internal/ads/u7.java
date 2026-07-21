package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class u7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13389f;

    u7(zzbcd zzbcdVar) {
        this.f13389f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13389f.w != null) {
            this.f13389f.w.i();
        }
    }
}
