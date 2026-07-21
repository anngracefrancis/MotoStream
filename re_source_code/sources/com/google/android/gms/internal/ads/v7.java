package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class v7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13445f;

    v7(zzbcd zzbcdVar) {
        this.f13445f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13445f.w != null) {
            this.f13445f.w.e();
        }
    }
}
