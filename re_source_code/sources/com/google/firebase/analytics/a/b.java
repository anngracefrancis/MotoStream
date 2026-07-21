package com.google.firebase.analytics.a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.h;
import com.google.firebase.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class b implements com.google.firebase.analytics.a.a {
    private static volatile com.google.firebase.analytics.a.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private final AppMeasurement f18853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<String, ?> f18854c;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
    class a implements com.google.firebase.analytics.a.a.InterfaceC0205a {
        private final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }
    }

    private b(AppMeasurement appMeasurement) {
        Preconditions.k(appMeasurement);
        this.f18853b = appMeasurement;
        this.f18854c = new ConcurrentHashMap();
    }

    @KeepForSdk
    public static com.google.firebase.analytics.a.a c(j jVar, Context context, com.google.firebase.q.d dVar) {
        Preconditions.k(jVar);
        Preconditions.k(context);
        Preconditions.k(dVar);
        Preconditions.k(context.getApplicationContext());
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    Bundle bundle = new Bundle(1);
                    if (jVar.s()) {
                        dVar.b(h.class, d.f18856f, c.a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", jVar.r());
                    }
                    a = new b(AppMeasurement.c(context, bundle));
                }
            }
        }
        return a;
    }

    static final /* synthetic */ void d(com.google.firebase.q.a aVar) {
        boolean z = ((h) aVar.a()).a;
        synchronized (b.class) {
            ((b) a).f18853b.e(z);
        }
    }

    private final boolean e(String str) {
        return (str.isEmpty() || !this.f18854c.containsKey(str) || this.f18854c.get(str) == null) ? false : true;
    }

    @Override // com.google.firebase.analytics.a.a
    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.c.a(str) && com.google.firebase.analytics.connector.internal.c.c(str, str2)) {
            this.f18853b.b(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.a.a
    @KeepForSdk
    public com.google.firebase.analytics.a.a.InterfaceC0205a b(String str, com.google.firebase.analytics.a.a.b bVar) {
        Object dVar;
        Preconditions.k(bVar);
        if (!com.google.firebase.analytics.connector.internal.c.a(str) || e(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.f18853b;
        if ("fiam".equals(str)) {
            dVar = new com.google.firebase.analytics.connector.internal.b(appMeasurement, bVar);
        } else {
            dVar = "crash".equals(str) ? new com.google.firebase.analytics.connector.internal.d(appMeasurement, bVar) : null;
        }
        if (dVar == null) {
            return null;
        }
        this.f18854c.put(str, dVar);
        return new a(str);
    }

    @Override // com.google.firebase.analytics.a.a
    @KeepForSdk
    public void m0(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.c.a(str) && com.google.firebase.analytics.connector.internal.c.b(str2, bundle) && com.google.firebase.analytics.connector.internal.c.d(str, str2, bundle)) {
            this.f18853b.logEventInternal(str, str2, bundle);
        }
    }
}
