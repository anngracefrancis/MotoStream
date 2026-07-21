package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class q6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzjc f17918f;

    q6(zzjc zzjcVar) {
        this.f17918f = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzik zzikVar = this.f17918f.f18201h;
        Context contextF = this.f17918f.f18201h.f();
        this.f17918f.f18201h.G();
        zzikVar.E(new ComponentName(contextF, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
