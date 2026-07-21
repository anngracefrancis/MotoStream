package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class q7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13225h;

    q7(zzbcd zzbcdVar, String str, String str2) {
        this.f13225h = zzbcdVar;
        this.f13223f = str;
        this.f13224g = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13225h.w != null) {
            this.f13225h.w.b(this.f13223f, this.f13224g);
        }
    }
}
