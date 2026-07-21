package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzan f17962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17964i;

    t4(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar, zzan zzanVar, String str) {
        this.f17964i = appMeasurementDynamiteService;
        this.f17961f = zznVar;
        this.f17962g = zzanVar;
        this.f17963h = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17964i.f17687f.R().H(this.f17961f, this.f17962g, this.f17963h);
    }
}
