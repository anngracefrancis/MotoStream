package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
final class l5 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhc f17851f;

    private l5(zzhc zzhcVar) {
        this.f17851f = zzhcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z, Uri uri, String str, String str2) {
        Bundle bundleY;
        Bundle bundleY2;
        try {
            if (this.f17851f.n().r(zzap.H0) || this.f17851f.n().r(zzap.J0) || this.f17851f.n().r(zzap.I0)) {
                zzkk zzkkVarL = this.f17851f.l();
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium")) {
                        bundleY = zzkkVarL.y(Uri.parse(str2.length() != 0 ? "https://google.com/search?".concat(str2) : new String("https://google.com/search?")));
                        if (bundleY != null) {
                            bundleY.putString("_cis", "referrer");
                        }
                    } else {
                        zzkkVarL.h().O().a("Activity created with data 'referrer' without required params");
                    }
                }
                bundleY = null;
            } else {
                bundleY = null;
            }
            boolean z2 = false;
            if (z) {
                bundleY2 = this.f17851f.l().y(uri);
                if (bundleY2 != null) {
                    bundleY2.putString("_cis", "intent");
                    if (this.f17851f.n().r(zzap.H0) && !bundleY2.containsKey("gclid") && bundleY != null && bundleY.containsKey("gclid")) {
                        bundleY2.putString("_cer", String.format("gclid=%s", bundleY.getString("gclid")));
                    }
                    this.f17851f.S(str, "_cmp", bundleY2);
                }
            } else {
                bundleY2 = null;
            }
            if (this.f17851f.n().r(zzap.J0) && !this.f17851f.n().r(zzap.I0) && bundleY != null && bundleY.containsKey("gclid") && (bundleY2 == null || !bundleY2.containsKey("gclid"))) {
                this.f17851f.W("auto", "_lgclid", bundleY.getString("gclid"), true);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f17851f.h().O().b("Activity created with referrer", str2);
            if (this.f17851f.n().r(zzap.I0)) {
                if (bundleY != null) {
                    this.f17851f.S(str, "_cmp", bundleY);
                } else {
                    this.f17851f.h().O().b("Referrer does not contain valid parameters", str2);
                }
                this.f17851f.W("auto", "_ldl", null, true);
                return;
            }
            if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                z2 = true;
            }
            if (!z2) {
                this.f17851f.h().O().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f17851f.W("auto", "_ldl", str2, true);
            }
        } catch (Exception e2) {
            this.f17851f.h().H().b("Throwable caught in handleReferrerForOnActivityCreated", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            try {
                this.f17851f.h().P().a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    this.f17851f.l();
                    String str = zzkk.V(intent) ? "gs" : "auto";
                    String queryParameter = data.getQueryParameter("referrer");
                    boolean z = bundle == null;
                    if (zzle.b() && zzap.K0.a(null).booleanValue()) {
                        this.f17851f.g().z(new n5(this, z, data, str, queryParameter));
                    } else {
                        b(z, data, str, queryParameter);
                    }
                }
            } catch (Exception e2) {
                this.f17851f.h().H().b("Throwable caught in onActivityCreated", e2);
            }
        } finally {
            this.f17851f.s().D(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f17851f.s().P(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f17851f.s().N(activity);
        zzjl zzjlVarU = this.f17851f.u();
        zzjlVarU.g().z(new u6(zzjlVarU, zzjlVarU.j().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (zzkn.b() && zzap.f0.a(null).booleanValue()) {
            this.f17851f.u().F();
            this.f17851f.s().C(activity);
        } else {
            this.f17851f.s().C(activity);
            this.f17851f.u().F();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f17851f.s().O(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* synthetic */ l5(zzhc zzhcVar, w4 w4Var) {
        this(zzhcVar);
    }
}
