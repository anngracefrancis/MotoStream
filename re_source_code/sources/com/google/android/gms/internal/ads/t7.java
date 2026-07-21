package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class t7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13348f;

    t7(zzbcd zzbcdVar) {
        this.f13348f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13348f.w != null) {
            this.f13348f.w.e();
            this.f13348f.w.g();
        }
    }
}
