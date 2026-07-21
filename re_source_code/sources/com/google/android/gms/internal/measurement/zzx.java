package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import cm.aptoide.pt.account.AdultContentAnalytics;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzha;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzx {
    private static volatile zzx a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f17571b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f17572c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f17573d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f17574e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private static String f17575f = "use_dynamite_api";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private static String f17576g = "allow_remote_dynamite";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f17577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Clock f17578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ExecutorService f17579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AppMeasurementSdk f17580k;
    private List<Pair<zzha, b>> l;
    private int m;
    private boolean n;
    private String o;
    private zzm p;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    abstract class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f17581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f17582g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f17583h;

        a(zzx zzxVar) {
            this(true);
        }

        abstract void a() throws RemoteException;

        protected void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzx.this.n) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                zzx.this.p(e2, false, this.f17583h);
                b();
            }
        }

        a(boolean z) {
            this.f17581f = zzx.this.f17578i.a();
            this.f17582g = zzx.this.f17578i.b();
            this.f17583h = z;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    static class b extends zzr {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final zzha f17585f;

        b(zzha zzhaVar) {
            this.f17585f = zzhaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzs
        public final int a() {
            return System.identityHashCode(this.f17585f);
        }

        @Override // com.google.android.gms.internal.measurement.zzs
        public final void q4(String str, String str2, Bundle bundle, long j2) {
            this.f17585f.a(str, str2, bundle, j2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzx.this.l(new t(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzx.this.l(new y(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzx.this.l(new x(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzx.this.l(new u(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzk zzkVar = new zzk();
            zzx.this.l(new z(this, activity, zzkVar));
            Bundle bundleE0 = zzkVar.E0(50L);
            if (bundleE0 != null) {
                bundle.putAll(bundleE0);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzx.this.l(new v(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzx.this.l(new w(this, activity));
        }
    }

    private zzx(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !J(str2, str3)) {
            this.f17577h = "FA";
        } else {
            this.f17577h = str;
        }
        this.f17578i = DefaultClock.c();
        this.f17579j = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f17580k = new AppMeasurementSdk(this);
        if (!(!R(context) || Y())) {
            this.o = null;
            this.n = true;
            Log.w(this.f17577h, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (J(str2, str3)) {
            this.o = str2;
        } else {
            this.o = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.f17577h, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.n = true;
                return;
            } else {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f17577h, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        }
        l(new com.google.android.gms.internal.measurement.a(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f17577h, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new c());
        }
    }

    public static boolean E(Context context) {
        W(context);
        synchronized (zzx.class) {
            if (!f17573d) {
                try {
                    try {
                        String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", HttpUrl.FRAGMENT_ENCODE_SET);
                        if ("true".equals(str)) {
                            f17574e = Boolean.TRUE;
                        } else if (AdultContentAnalytics.UNLOCK.equals(str)) {
                            f17574e = Boolean.FALSE;
                        } else {
                            f17574e = null;
                        }
                        f17573d = true;
                    } catch (Throwable th) {
                        f17573d = true;
                        throw th;
                    }
                } catch (Exception e2) {
                    Log.e("FA", "Unable to call SystemProperties.get()", e2);
                    f17574e = null;
                    f17573d = true;
                }
            }
        }
        Boolean bool = f17574e;
        if (bool == null) {
            bool = f17571b;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean J(String str, String str2) {
        return (str2 == null || str == null || Y()) ? false : true;
    }

    private static boolean R(Context context) {
        try {
            GoogleServices.c(context);
            return GoogleServices.b() != null;
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int S(Context context) {
        return DynamiteModule.c(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int U(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(Context context) {
        synchronized (zzx.class) {
            try {
                if (f17571b == null || f17572c == null) {
                    if (w(context, "app_measurement_internal_disable_startup_flags")) {
                        Boolean bool = Boolean.FALSE;
                        f17571b = bool;
                        f17572c = bool;
                        return;
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    f17571b = Boolean.valueOf(sharedPreferences.getBoolean(f17575f, false));
                    f17572c = Boolean.valueOf(sharedPreferences.getBoolean(f17576g, false));
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.remove(f17575f);
                    editorEdit.remove(f17576g);
                    editorEdit.apply();
                }
            } catch (Exception e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                Boolean bool2 = Boolean.FALSE;
                f17571b = bool2;
                f17572c = bool2;
            }
        }
    }

    private static boolean Y() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static zzx d(Context context) {
        return e(context, null, null, null, null);
    }

    public static zzx e(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.k(context);
        if (a == null) {
            synchronized (zzx.class) {
                if (a == null) {
                    a = new zzx(context, str, str2, str3, bundle);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(a aVar) {
        this.f17579j.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Exception exc, boolean z, boolean z2) {
        this.n |= z;
        if (z) {
            Log.w(this.f17577h, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            i(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.f17577h, "Error with data collection. Data lost.", exc);
    }

    private final void t(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        l(new r(this, l, str, str2, bundle, z, z2));
    }

    private final void v(String str, String str2, Object obj, boolean z) {
        l(new q(this, str, str2, obj, z));
    }

    private static boolean w(Context context, String str) {
        Bundle bundle;
        Preconditions.g(str);
        try {
            ApplicationInfo applicationInfoC = Wrappers.a(context).c(context.getPackageName(), 128);
            if (applicationInfoC != null && (bundle = applicationInfoC.metaData) != null) {
                return bundle.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final List<Bundle> A(String str, String str2) {
        zzk zzkVar = new zzk();
        l(new com.google.android.gms.internal.measurement.b(this, str, str2, zzkVar));
        List<Bundle> list = (List) zzk.P(zzkVar.E0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void B(String str) {
        l(new d(this, str));
    }

    public final void C(String str, String str2, Bundle bundle) {
        l(new z4(this, str, str2, bundle));
    }

    public final void D(boolean z) {
        l(new p(this, z));
    }

    public final String G() {
        zzk zzkVar = new zzk();
        l(new g(this, zzkVar));
        return zzkVar.k0(500L);
    }

    public final void I(String str) {
        l(new e(this, str));
    }

    public final int L(String str) {
        zzk zzkVar = new zzk();
        l(new n(this, str, zzkVar));
        Integer num = (Integer) zzk.P(zzkVar.E0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String M() {
        zzk zzkVar = new zzk();
        l(new f(this, zzkVar));
        return zzkVar.k0(50L);
    }

    public final long P() {
        zzk zzkVar = new zzk();
        l(new i(this, zzkVar));
        Long l = (Long) zzk.P(zzkVar.E0(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.f17578i.a()).nextLong();
        int i2 = this.m + 1;
        this.m = i2;
        return jNextLong + ((long) i2);
    }

    public final String Q() {
        zzk zzkVar = new zzk();
        l(new h(this, zzkVar));
        return zzkVar.k0(500L);
    }

    public final String T() {
        zzk zzkVar = new zzk();
        l(new k(this, zzkVar));
        return zzkVar.k0(500L);
    }

    public final String V() {
        return this.o;
    }

    public final Bundle a(Bundle bundle, boolean z) {
        zzk zzkVar = new zzk();
        l(new l(this, bundle, zzkVar));
        if (z) {
            return zzkVar.E0(5000L);
        }
        return null;
    }

    protected final zzm b(Context context, boolean z) {
        try {
            return zzl.asInterface(DynamiteModule.e(context, z ? DynamiteModule.f12197f : DynamiteModule.f12193b, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e2) {
            p(e2, true, false);
            return null;
        }
    }

    public final AppMeasurementSdk f() {
        return this.f17580k;
    }

    public final Map<String, Object> h(String str, String str2, boolean z) {
        zzk zzkVar = new zzk();
        l(new j(this, str, str2, z, zzkVar));
        Bundle bundleE0 = zzkVar.E0(5000L);
        if (bundleE0 == null || bundleE0.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleE0.size());
        for (String str3 : bundleE0.keySet()) {
            Object obj = bundleE0.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void i(int i2, String str, Object obj, Object obj2, Object obj3) {
        l(new m(this, false, 5, str, obj, null, null));
    }

    public final void j(Activity activity, String str, String str2) {
        l(new com.google.android.gms.internal.measurement.c(this, activity, str, str2));
    }

    public final void k(Bundle bundle) {
        l(new s(this, bundle));
    }

    public final void o(zzha zzhaVar) {
        Preconditions.k(zzhaVar);
        l(new o(this, zzhaVar));
    }

    public final void q(String str, Bundle bundle) {
        t(null, str, bundle, false, true, null);
    }

    public final void r(String str, String str2) {
        v(null, str, str2, false);
    }

    public final void s(String str, String str2, Bundle bundle) {
        t(str, str2, bundle, true, true, null);
    }

    public final void u(String str, String str2, Object obj) {
        v(str, str2, obj, true);
    }
}
