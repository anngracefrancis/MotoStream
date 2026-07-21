package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g7 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f17782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17783j;

    g7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar, String str, String str2, boolean z) {
        this.f17783j = appMeasurementDynamiteService;
        this.f17779f = zznVar;
        this.f17780g = str;
        this.f17781h = str2;
        this.f17782i = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17783j.f17687f.R().J(this.f17779f, this.f17780g, this.f17781h, this.f17782i);
    }
}
