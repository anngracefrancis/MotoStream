package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class kz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Surface f12897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhd f12898g;

    kz(zzhd zzhdVar, Surface surface) {
        this.f12898g = zzhdVar;
        this.f12897f = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12898g.H.g(this.f12897f);
    }
}
