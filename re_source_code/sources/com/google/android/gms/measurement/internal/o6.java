package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ComponentName f17897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjc f17898g;

    o6(zzjc zzjcVar, ComponentName componentName) {
        this.f17898g = zzjcVar;
        this.f17897f = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17898g.f18201h.E(this.f17897f);
    }
}
