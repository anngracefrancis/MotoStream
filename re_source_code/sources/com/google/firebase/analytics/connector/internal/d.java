package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private com.google.firebase.analytics.a.a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppMeasurement f18865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f18866c;

    public d(AppMeasurement appMeasurement, com.google.firebase.analytics.a.a.b bVar) {
        this.a = bVar;
        this.f18865b = appMeasurement;
        f fVar = new f(this);
        this.f18866c = fVar;
        this.f18865b.a(fVar);
    }
}
