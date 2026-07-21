package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzw;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzfx f18849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzx f18850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f18851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f18852e;

    private FirebaseAnalytics(zzfx zzfxVar) {
        Preconditions.k(zzfxVar);
        this.f18849b = zzfxVar;
        this.f18850c = null;
        this.f18851d = false;
        this.f18852e = new Object();
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (a == null) {
                    if (zzx.E(context)) {
                        a = new FirebaseAnalytics(zzx.d(context));
                    } else {
                        a = new FirebaseAnalytics(zzfx.a(context, null));
                    }
                }
            }
        }
        return a;
    }

    @Keep
    public static zzhx getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzx zzxVarE;
        if (zzx.E(context) && (zzxVarE = zzx.e(context, null, null, null, bundle)) != null) {
            return new b(zzxVarE);
        }
        return null;
    }

    public final void a(String str, Bundle bundle) {
        if (this.f18851d) {
            this.f18850c.q(str, bundle);
        } else {
            this.f18849b.H().T("app", str, bundle, true);
        }
    }

    public final void b(String str, String str2) {
        if (this.f18851d) {
            this.f18850c.r(str, str2);
        } else {
            this.f18849b.H().W("app", str, str2, false);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.j().h();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f18851d) {
            this.f18850c.j(activity, str, str2);
        } else if (zzw.a()) {
            this.f18849b.Q().F(activity, str, str2);
        } else {
            this.f18849b.h().K().a("setCurrentScreen must be called from the main thread");
        }
    }

    private FirebaseAnalytics(zzx zzxVar) {
        Preconditions.k(zzxVar);
        this.f18849b = null;
        this.f18850c = zzxVar;
        this.f18851d = true;
        this.f18852e = new Object();
    }
}
