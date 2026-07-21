package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class y0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f11797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f11798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzd f11799h;

    y0(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.f11799h = zzdVar;
        this.f11797f = lifecycleCallback;
        this.f11798g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.f11799h;
        if (zzdVar.f11893h > 0) {
            this.f11797f.e(zzdVar.f11894i != null ? zzdVar.f11894i.getBundle(this.f11798g) : null);
        }
        if (this.f11799h.f11893h >= 2) {
            this.f11797f.i();
        }
        if (this.f11799h.f11893h >= 3) {
            this.f11797f.g();
        }
        if (this.f11799h.f11893h >= 4) {
            this.f11797f.j();
        }
        if (this.f11799h.f11893h >= 5) {
            this.f11797f.f();
        }
    }
}
