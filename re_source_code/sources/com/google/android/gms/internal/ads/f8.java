package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class f8 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbcq f12571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12572g = false;

    f8(zzbcq zzbcqVar) {
        this.f12571f = zzbcqVar;
    }

    private final void c() {
        Handler handler = zzaxi.a;
        handler.removeCallbacks(this);
        handler.postDelayed(this, 250L);
    }

    public final void a() {
        this.f12572g = true;
        this.f12571f.G();
    }

    public final void b() {
        this.f12572g = false;
        c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12572g) {
            return;
        }
        this.f12571f.G();
        c();
    }
}
