package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f11794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f11795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzb f11796h;

    x0(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f11796h = zzbVar;
        this.f11794f = lifecycleCallback;
        this.f11795g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.f11796h;
        if (zzbVar.f11889h > 0) {
            this.f11794f.e(zzbVar.f11890i != null ? zzbVar.f11890i.getBundle(this.f11795g) : null);
        }
        if (this.f11796h.f11889h >= 2) {
            this.f11794f.i();
        }
        if (this.f11796h.f11889h >= 3) {
            this.f11794f.g();
        }
        if (this.f11796h.f11889h >= 4) {
            this.f11794f.j();
        }
        if (this.f11796h.f11889h >= 5) {
            this.f11794f.f();
        }
    }
}
