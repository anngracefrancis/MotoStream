package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class a40 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Surface f12217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f12218g;

    a40(zzto zztoVar, Surface surface) {
        this.f12218g = zztoVar;
        this.f12217f = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12218g.f16775b.j(this.f12217f);
    }
}
