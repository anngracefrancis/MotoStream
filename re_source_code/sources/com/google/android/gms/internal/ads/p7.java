package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class p7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13154f;

    p7(zzbcd zzbcdVar) {
        this.f13154f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13154f.w != null) {
            this.f13154f.w.h();
        }
    }
}
