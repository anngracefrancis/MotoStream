package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.firebase.analytics.a.a.b f18857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppMeasurement f18858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f18859d;

    public b(AppMeasurement appMeasurement, com.google.firebase.analytics.a.a.b bVar) {
        this.f18857b = bVar;
        this.f18858c = appMeasurement;
        e eVar = new e(this);
        this.f18859d = eVar;
        this.f18858c.a(eVar);
        this.a = new HashSet();
    }
}
