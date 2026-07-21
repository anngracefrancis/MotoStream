package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
final class f5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f12565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzaxi f12566g;

    f5(zzaxi zzaxiVar, Context context) {
        this.f12566g = zzaxiVar;
        this.f12565f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f12566g.f14258e) {
            this.f12566g.f14259f = zzaxi.w(this.f12565f);
            this.f12566g.f14258e.notifyAll();
        }
    }
}
