package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.internal.p0;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserSettingsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public static final n0 a = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10076b = n0.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f10077c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f10078d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f10079e = new a(true, "com.facebook.sdk.AutoInitEnabled");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f10080f = new a(true, "com.facebook.sdk.AutoLogAppEventsEnabled");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a f10081g = new a(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f10082h = new a(false, "auto_event_setup_enabled");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f10083i = new a(true, "com.facebook.sdk.MonitorEnabled");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static SharedPreferences f10084j;

    /* JADX INFO: compiled from: UserSettingsManager.kt */
    private static final class a {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Boolean f10086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f10087d;

        public a(boolean z, String str) {
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            this.a = z;
            this.f10085b = str;
        }

        public final boolean a() {
            return this.a;
        }

        public final String b() {
            return this.f10085b;
        }

        public final long c() {
            return this.f10087d;
        }

        public final Boolean d() {
            return this.f10086c;
        }

        public final boolean e() {
            Boolean bool = this.f10086c;
            return bool == null ? this.a : bool.booleanValue();
        }

        public final void f(long j2) {
            this.f10087d = j2;
        }

        public final void g(Boolean bool) {
            this.f10086c = bool;
        }
    }

    private n0() {
    }

    public static final boolean a() {
        a.g();
        return f10081g.e();
    }

    public static final boolean b() {
        a.g();
        return f10079e.e();
    }

    public static final boolean c() {
        a.g();
        return f10080f.e();
    }

    public static final boolean d() {
        a.g();
        return f10082h.e();
    }

    private final void e() {
        a aVar = f10082h;
        n(aVar);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (aVar.d() == null || jCurrentTimeMillis - aVar.c() >= 604800000) {
            aVar.g(null);
            aVar.f(0L);
            if (f10078d.compareAndSet(false, true)) {
                a0 a0Var = a0.a;
                a0.k().execute(new Runnable() { // from class: com.facebook.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        n0.f(jCurrentTimeMillis);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j2) {
        if (f10081g.e()) {
            com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
            a0 a0Var = a0.a;
            com.facebook.internal.c0 c0VarO = com.facebook.internal.d0.o(a0.d(), false);
            if (c0VarO != null && c0VarO.b()) {
                com.facebook.internal.q qVarE = com.facebook.internal.q.a.e(a0.c());
                String strH = (qVarE == null || qVarE.h() == null) ? null : qVarE.h();
                if (strH != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("advertiser_id", strH);
                    bundle.putString("fields", "auto_event_setup_enabled");
                    GraphRequest graphRequestX = GraphRequest.a.x(null, "app", null);
                    graphRequestX.H(bundle);
                    JSONObject jSONObjectC = graphRequestX.j().c();
                    if (jSONObjectC != null) {
                        a aVar = f10082h;
                        aVar.g(Boolean.valueOf(jSONObjectC.optBoolean("auto_event_setup_enabled", false)));
                        aVar.f(j2);
                        a.p(aVar);
                    }
                }
            }
        }
        f10078d.set(false);
    }

    private final void g() {
        a0 a0Var = a0.a;
        if (a0.w() && f10077c.compareAndSet(false, true)) {
            SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
            kotlin.jvm.internal.m.e(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
            f10084j = sharedPreferences;
            h(f10080f, f10081g, f10079e);
            e();
            m();
            l();
        }
    }

    private final void h(a... aVarArr) {
        int length = aVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            a aVar = aVarArr[i2];
            i2++;
            if (aVar == f10082h) {
                e();
            } else if (aVar.d() == null) {
                n(aVar);
                if (aVar.d() == null) {
                    j(aVar);
                }
            } else {
                p(aVar);
            }
        }
    }

    private final void j(a aVar) {
        o();
        try {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            ApplicationInfo applicationInfo = contextC.getPackageManager().getApplicationInfo(contextC.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null || !bundle.containsKey(aVar.b())) {
                return;
            }
            aVar.g(Boolean.valueOf(applicationInfo.metaData.getBoolean(aVar.b(), aVar.a())));
        } catch (PackageManager.NameNotFoundException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10076b, e2);
        }
    }

    public static final void k() {
        try {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            ApplicationInfo applicationInfo = contextC.getPackageManager().getApplicationInfo(contextC.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null || !bundle.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                return;
            }
            com.facebook.o0.g0 g0Var = new com.facebook.o0.g0(contextC);
            Bundle bundle2 = new Bundle();
            p0 p0Var = p0.a;
            if (!p0.S()) {
                bundle2.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                Log.w(f10076b, "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
            }
            g0Var.d("fb_auto_applink", bundle2);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void l() {
        int i2;
        int i3;
        if (f10077c.get()) {
            a0 a0Var = a0.a;
            if (a0.w()) {
                Context contextC = a0.c();
                int i4 = 0;
                int i5 = ((f10079e.e() ? 1 : 0) << 0) | 0 | ((f10080f.e() ? 1 : 0) << 1) | ((f10081g.e() ? 1 : 0) << 2) | ((f10083i.e() ? 1 : 0) << 3);
                SharedPreferences sharedPreferences = f10084j;
                if (sharedPreferences == null) {
                    kotlin.jvm.internal.m.w("userSettingPref");
                    throw null;
                }
                int i6 = sharedPreferences.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                if (i6 != i5) {
                    SharedPreferences sharedPreferences2 = f10084j;
                    if (sharedPreferences2 == null) {
                        kotlin.jvm.internal.m.w("userSettingPref");
                        throw null;
                    }
                    sharedPreferences2.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i5).apply();
                    try {
                        ApplicationInfo applicationInfo = contextC.getPackageManager().getApplicationInfo(contextC.getPackageName(), 128);
                        kotlin.jvm.internal.m.e(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                        if (applicationInfo.metaData != null) {
                            String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                            boolean[] zArr = {true, true, true, true};
                            int i7 = 0;
                            i2 = 0;
                            i3 = 0;
                            while (true) {
                                int i8 = i7 + 1;
                                try {
                                    i2 |= (applicationInfo.metaData.containsKey(strArr[i7]) ? 1 : 0) << i7;
                                    i3 |= (applicationInfo.metaData.getBoolean(strArr[i7], zArr[i7]) ? 1 : 0) << i7;
                                    if (i8 > 3) {
                                        break;
                                    } else {
                                        i7 = i8;
                                    }
                                } catch (PackageManager.NameNotFoundException unused) {
                                    i4 = i3;
                                    i3 = i4;
                                }
                            }
                            i4 = i2;
                        } else {
                            i3 = 0;
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        i2 = 0;
                    }
                    com.facebook.o0.g0 g0Var = new com.facebook.o0.g0(contextC);
                    Bundle bundle = new Bundle();
                    bundle.putInt("usage", i4);
                    bundle.putInt("initial", i3);
                    bundle.putInt("previous", i6);
                    bundle.putInt("current", i5);
                    g0Var.b(bundle);
                }
            }
        }
    }

    private final void m() {
        try {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            ApplicationInfo applicationInfo = contextC.getPackageManager().getApplicationInfo(contextC.getPackageName(), 128);
            kotlin.jvm.internal.m.e(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                if (!bundle.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                    Log.w(f10076b, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    Log.w(f10076b, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (a()) {
                    return;
                }
                Log.w(f10076b, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void n(a aVar) {
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        o();
        try {
            SharedPreferences sharedPreferences = f10084j;
            if (sharedPreferences == null) {
                kotlin.jvm.internal.m.w("userSettingPref");
                throw null;
            }
            String string = sharedPreferences.getString(aVar.b(), HttpUrl.FRAGMENT_ENCODE_SET);
            if (string != null) {
                str = string;
            }
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject(str);
                aVar.g(Boolean.valueOf(jSONObject.getBoolean("value")));
                aVar.f(jSONObject.getLong("last_timestamp"));
            }
        } catch (JSONException e2) {
            p0 p0Var = p0.a;
            p0.i0(f10076b, e2);
        }
    }

    private final void o() {
        if (!f10077c.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    private final void p(a aVar) {
        o();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", aVar.d());
            jSONObject.put("last_timestamp", aVar.c());
            SharedPreferences sharedPreferences = f10084j;
            if (sharedPreferences == null) {
                kotlin.jvm.internal.m.w("userSettingPref");
                throw null;
            }
            sharedPreferences.edit().putString(aVar.b(), jSONObject.toString()).apply();
            l();
        } catch (Exception e2) {
            p0 p0Var = p0.a;
            p0.i0(f10076b, e2);
        }
    }
}
