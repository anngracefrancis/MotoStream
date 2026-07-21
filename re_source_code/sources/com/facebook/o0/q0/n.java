package com.facebook.o0.q0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.facebook.internal.j0;
import com.facebook.o0.a0;
import com.facebook.o0.g0;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SessionLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final n a = new n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10436b = n.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long[] f10437c = {LocalNotificationSyncManager.FIVE_MINUTES, 900000, BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS, 3600000, 21600000, 43200000, PullingContentService.UPDATES_INTERVAL, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    private n() {
    }

    private final String a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String strN = kotlin.jvm.internal.m.n("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(strN, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            l lVar = l.a;
            String strC = l.c(context, null);
            if (strC == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                kotlin.jvm.internal.m.e(applicationInfo, "pm.getApplicationInfo(context.packageName, 0)");
                strC = l.b(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(strN, strC).apply();
            return strC;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final int b(long j2) {
        int i2 = 0;
        while (true) {
            long[] jArr = f10437c;
            if (i2 >= jArr.length || jArr[i2] >= j2) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static final void c(String str, o oVar, String str2, Context context) {
        String string;
        kotlin.jvm.internal.m.f(str, "activityName");
        kotlin.jvm.internal.m.f(context, "context");
        String str3 = "Unclassified";
        if (oVar != null && (string = oVar.toString()) != null) {
            str3 = string;
        }
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", str3);
        bundle.putString("fb_mobile_pckg_fp", a.a(context));
        com.facebook.internal.v0.b bVar = com.facebook.internal.v0.b.a;
        bundle.putString("fb_mobile_app_cert_hash", com.facebook.internal.v0.b.a(context));
        g0.a aVar = g0.a;
        g0 g0VarA = aVar.a(str, str2, null);
        g0VarA.d("fb_mobile_activate_app", bundle);
        if (aVar.c() != a0.b.EXPLICIT_ONLY) {
            g0VarA.a();
        }
    }

    private final void d() {
        j0.a aVar = j0.a;
        com.facebook.g0 g0Var = com.facebook.g0.APP_EVENTS;
        String str = f10436b;
        kotlin.jvm.internal.m.c(str);
        aVar.b(g0Var, str, "Clock skew detected");
    }

    public static final void e(String str, m mVar, String str2) {
        long jLongValue;
        String string;
        kotlin.jvm.internal.m.f(str, "activityName");
        if (mVar == null) {
            return;
        }
        Long lB = mVar.b();
        if (lB == null) {
            Long lE = mVar.e();
            jLongValue = 0 - (lE == null ? 0L : lE.longValue());
        } else {
            jLongValue = lB.longValue();
        }
        if (jLongValue < 0) {
            a.d();
            jLongValue = 0;
        }
        long jF = mVar.f();
        if (jF < 0) {
            a.d();
            jF = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", mVar.c());
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str3 = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(b(jLongValue))}, 1));
        kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
        bundle.putString("fb_mobile_time_between_sessions", str3);
        o oVarG = mVar.g();
        String str4 = "Unclassified";
        if (oVarG != null && (string = oVarG.toString()) != null) {
            str4 = string;
        }
        bundle.putString("fb_mobile_launch_source", str4);
        Long lE2 = mVar.e();
        bundle.putLong("_logTime", (lE2 != null ? lE2.longValue() : 0L) / ((long) 1000));
        g0 g0VarA = g0.a.a(str, str2, null);
        double d2 = jF;
        double d3 = 1000L;
        Double.isNaN(d2);
        Double.isNaN(d3);
        g0VarA.c("fb_mobile_deactivate_app", d2 / d3, bundle);
    }
}
