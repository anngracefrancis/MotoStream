package com.facebook.o0;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* JADX INFO: compiled from: AppEventsLoggerImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f10098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a0.b f10099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f10100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f10101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f10102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f10103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f10104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t f10105j;

    /* JADX INFO: compiled from: AppEventsLoggerImpl.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.facebook.o0.b0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppEventsLoggerImpl.kt */
        public static final class C0146a implements com.facebook.internal.g0.a {
            C0146a() {
            }

            @Override // com.facebook.internal.g0.a
            public void a(String str) {
                b0.a.t(str);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(Context context, b0 b0Var) {
            kotlin.jvm.internal.m.f(context, "$context");
            kotlin.jvm.internal.m.f(b0Var, "$logger");
            Bundle bundle = new Bundle();
            String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
            String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                String str = strArr[i2];
                String str2 = strArr2[i2];
                try {
                    Class.forName(str);
                    bundle.putInt(str2, 1);
                    i3 |= 1 << i2;
                } catch (ClassNotFoundException unused) {
                }
                if (i4 > 10) {
                    break;
                } else {
                    i2 = i4;
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (sharedPreferences.getInt("kitsBitmask", 0) != i3) {
                sharedPreferences.edit().putInt("kitsBitmask", i3).apply();
                b0Var.p("fb_sdk_initialize", null, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m() {
            synchronized (b0.f10100e) {
                if (b0.f10098c != null) {
                    return;
                }
                a aVar = b0.a;
                b0.f10098c = new ScheduledThreadPoolExecutor(1);
                kotlin.u uVar = kotlin.u.a;
                i iVar = new Runnable() { // from class: com.facebook.o0.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.n();
                    }
                };
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = b0.f10098c;
                if (scheduledThreadPoolExecutor == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, 0L, 86400L, TimeUnit.SECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n() {
            HashSet<String> hashSet = new HashSet();
            y yVar = y.a;
            Iterator<t> it = y.j().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().b());
            }
            for (String str : hashSet) {
                com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
                com.facebook.internal.d0.o(str, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(v vVar, t tVar) {
            y yVar = y.a;
            y.a(tVar, vVar);
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            if (com.facebook.internal.a0.g(com.facebook.internal.a0.b.OnDevicePostInstallEventProcessing)) {
                com.facebook.o0.s0.c cVar = com.facebook.o0.s0.c.a;
                if (com.facebook.o0.s0.c.b()) {
                    com.facebook.o0.s0.c.e(tVar.b(), vVar);
                }
            }
            if (vVar.c() || b0.f10102g) {
                return;
            }
            if (kotlin.jvm.internal.m.a(vVar.f(), "fb_mobile_activate_app")) {
                b0.f10102g = true;
            } else {
                com.facebook.internal.j0.a.b(com.facebook.g0.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(String str) {
            com.facebook.internal.j0.a.b(com.facebook.g0.DEVELOPER_ERRORS, "AppEvents", str);
        }

        public final void d(Application application, String str) {
            kotlin.jvm.internal.m.f(application, "application");
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (!com.facebook.a0.w()) {
                throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            }
            u uVar = u.a;
            u.c();
            j0 j0Var = j0.a;
            j0.d();
            if (str == null) {
                str = com.facebook.a0.d();
            }
            com.facebook.a0.K(application, str);
            com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
            com.facebook.o0.q0.f.x(application, str);
        }

        public final void e() {
            if (h() != a0.b.EXPLICIT_ONLY) {
                y yVar = y.a;
                y.f(d0.EAGER_FLUSHING_EVENT);
            }
        }

        public final Executor f() {
            if (b0.f10098c == null) {
                m();
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = b0.f10098c;
            if (scheduledThreadPoolExecutor != null) {
                return scheduledThreadPoolExecutor;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final String g(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            if (b0.f10101f == null) {
                synchronized (b0.f10100e) {
                    if (b0.f10101f == null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                        a aVar = b0.a;
                        b0.f10101f = sharedPreferences.getString("anonymousAppDeviceGUID", null);
                        if (b0.f10101f == null) {
                            UUID uuidRandomUUID = UUID.randomUUID();
                            kotlin.jvm.internal.m.e(uuidRandomUUID, "randomUUID()");
                            b0.f10101f = kotlin.jvm.internal.m.n("XZ", uuidRandomUUID);
                            context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", b0.f10101f).apply();
                        }
                    }
                    kotlin.u uVar = kotlin.u.a;
                }
            }
            String str = b0.f10101f;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final a0.b h() {
            a0.b bVar;
            synchronized (b0.f10100e) {
                bVar = b0.f10099d;
            }
            return bVar;
        }

        public final String i() {
            com.facebook.internal.g0 g0Var = com.facebook.internal.g0.a;
            com.facebook.internal.g0.d(new C0146a());
            com.facebook.a0 a0Var = com.facebook.a0.a;
            return com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", null);
        }

        public final String j() {
            String str;
            synchronized (b0.f10100e) {
                str = b0.f10103h;
            }
            return str;
        }

        public final void k(final Context context, String str) {
            kotlin.jvm.internal.m.f(context, "context");
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (com.facebook.a0.g()) {
                final b0 b0Var = new b0(context, str, (AccessToken) null);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = b0.f10098c;
                if (scheduledThreadPoolExecutor == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                scheduledThreadPoolExecutor.execute(new Runnable() { // from class: com.facebook.o0.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.l(context, b0Var);
                    }
                });
            }
        }

        public final void s() {
            y yVar = y.a;
            y.s();
        }

        public final void t(String str) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            SharedPreferences sharedPreferences = com.facebook.a0.c().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (str != null) {
                sharedPreferences.edit().putString("install_referrer", str).apply();
            }
        }
    }

    static {
        String canonicalName = b0.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        f10097b = canonicalName;
        f10099d = a0.b.AUTO;
        f10100e = new Object();
    }

    public b0(String str, String str2, AccessToken accessToken) {
        kotlin.jvm.internal.m.f(str, "activityName");
        q0 q0Var = q0.a;
        q0.l();
        this.f10104i = str;
        accessToken = accessToken == null ? AccessToken.f9559f.e() : accessToken;
        if (accessToken == null || accessToken.n() || !(str2 == null || kotlin.jvm.internal.m.a(str2, accessToken.c()))) {
            if (str2 == null) {
                p0 p0Var = p0.a;
                com.facebook.a0 a0Var = com.facebook.a0.a;
                str2 = p0.H(com.facebook.a0.c());
            }
            if (str2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.f10105j = new t(null, str2);
        } else {
            this.f10105j = new t(accessToken);
        }
        a.m();
    }

    public final void j() {
        y yVar = y.a;
        y.f(d0.EXPLICIT);
    }

    public final void k(String str) {
        m(str, null);
    }

    public final void l(String str, double d2, Bundle bundle) {
        Double dValueOf = Double.valueOf(d2);
        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
        n(str, dValueOf, bundle, false, com.facebook.o0.q0.f.h());
    }

    public final void m(String str, Bundle bundle) {
        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
        n(str, null, bundle, false, com.facebook.o0.q0.f.h());
    }

    public final void n(String str, Double d2, Bundle bundle, boolean z, UUID uuid) {
        if (str != null) {
            if (str.length() == 0) {
                return;
            }
            com.facebook.internal.b0 b0Var = com.facebook.internal.b0.a;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            if (com.facebook.internal.b0.b("app_events_killswitch", com.facebook.a0.d(), false)) {
                com.facebook.internal.j0.a.c(com.facebook.g0.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
                return;
            }
            try {
                com.facebook.o0.p0.b bVar = com.facebook.o0.p0.b.a;
                com.facebook.o0.p0.b.h(bundle, str);
                com.facebook.o0.p0.c cVar = com.facebook.o0.p0.c.a;
                com.facebook.o0.p0.c.e(bundle);
                String str2 = this.f10104i;
                com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
                a.q(new v(str2, str, d2, bundle, z, com.facebook.o0.q0.f.j(), uuid), this.f10105j);
            } catch (FacebookException e2) {
                com.facebook.internal.j0.a.c(com.facebook.g0.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
            } catch (JSONException e3) {
                com.facebook.internal.j0.a.c(com.facebook.g0.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e3.toString());
            }
        }
    }

    public final void o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_is_suggested_event", "1");
        bundle.putString("_button_text", str2);
        m(str, bundle);
    }

    public final void p(String str, Double d2, Bundle bundle) {
        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
        n(str, d2, bundle, true, com.facebook.o0.q0.f.h());
    }

    public final void q(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null || currency == null) {
            p0 p0Var = p0.a;
            p0.j0(f10097b, "purchaseAmount and currency cannot be null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putString("fb_currency", currency.getCurrencyCode());
        Double dValueOf = Double.valueOf(bigDecimal.doubleValue());
        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
        n(str, dValueOf, bundle2, true, com.facebook.o0.q0.f.h());
    }

    public final void r(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            a.r("purchaseAmount cannot be null");
            return;
        }
        if (currency == null) {
            a.r("currency cannot be null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putString("fb_currency", currency.getCurrencyCode());
        Double dValueOf = Double.valueOf(bigDecimal.doubleValue());
        com.facebook.o0.q0.f fVar = com.facebook.o0.q0.f.a;
        n("fb_mobile_purchase", dValueOf, bundle2, z, com.facebook.o0.q0.f.h());
        a.e();
    }

    public final void s(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        r(bigDecimal, currency, bundle, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(Context context, String str, AccessToken accessToken) {
        this(p0.r(context), str, accessToken);
        p0 p0Var = p0.a;
    }
}
