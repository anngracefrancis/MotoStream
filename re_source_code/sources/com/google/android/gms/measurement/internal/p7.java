package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class p7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17911g;

    p7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar) {
        this.f17911g = appMeasurementDynamiteService;
        this.f17910f = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17911g.f17687f.I().R(this.f17910f, this.f17911g.f17687f.o());
    }
}
