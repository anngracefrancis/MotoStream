package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e implements AppMeasurement.OnEventListener {
    private final /* synthetic */ b a;

    public e(b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final void a(String str, String str2, Bundle bundle, long j2) {
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", c.f(str2));
            this.a.f18857b.a(2, bundle2);
        }
    }
}
