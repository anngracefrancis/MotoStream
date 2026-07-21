package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ab implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbhk f12238f;

    ab(zzbhk zzbhkVar) {
        this.f12238f = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12238f.f14458f.destroy();
    }
}
