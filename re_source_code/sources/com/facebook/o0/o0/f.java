package com.facebook.o0.o0;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.a0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppPurchaseActivityLifecycleTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10351b = f.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f10352c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f10353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f10354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ServiceConnection f10355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f10356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Intent f10357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Object f10358i;

    /* JADX INFO: compiled from: InAppPurchaseActivityLifecycleTracker.kt */
    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            kotlin.jvm.internal.m.f(componentName, "name");
            kotlin.jvm.internal.m.f(iBinder, "service");
            f fVar = f.a;
            i iVar = i.a;
            a0 a0Var = a0.a;
            f.f10358i = i.a(a0.c(), iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            kotlin.jvm.internal.m.f(componentName, "name");
        }
    }

    /* JADX INFO: compiled from: InAppPurchaseActivityLifecycleTracker.kt */
    public static final class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            i iVar = i.a;
            ArrayList<String> arrayListI = i.i(contextC, f.f10358i);
            f fVar = f.a;
            fVar.f(contextC, arrayListI, false);
            fVar.f(contextC, i.j(contextC, f.f10358i), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d() {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            i iVar = i.a;
            ArrayList<String> arrayListI = i.i(contextC, f.f10358i);
            if (arrayListI.isEmpty()) {
                arrayListI = i.g(contextC, f.f10358i);
            }
            f.a.f(contextC, arrayListI, false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.m.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            try {
                a0 a0Var = a0.a;
                a0.k().execute(new Runnable() { // from class: com.facebook.o0.o0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.b.c();
                    }
                });
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.m.f(activity, "activity");
            kotlin.jvm.internal.m.f(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            try {
                if (kotlin.jvm.internal.m.a(f.f10354e, Boolean.TRUE) && kotlin.jvm.internal.m.a(activity.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                    a0 a0Var = a0.a;
                    a0.k().execute(new Runnable() { // from class: com.facebook.o0.o0.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.b.d();
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    private f() {
    }

    private final void e() {
        if (f10353d != null) {
            return;
        }
        m mVar = m.a;
        Boolean boolValueOf = Boolean.valueOf(m.a("com.android.vending.billing.IInAppBillingService$Stub") != null);
        f10353d = boolValueOf;
        if (kotlin.jvm.internal.m.a(boolValueOf, Boolean.FALSE)) {
            return;
        }
        f10354e = Boolean.valueOf(m.a("com.android.billingclient.api.ProxyBillingActivity") != null);
        i iVar = i.a;
        i.b();
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
        kotlin.jvm.internal.m.e(intent, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
        f10357h = intent;
        f10355f = new a();
        f10356g = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Context context, ArrayList<String> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            try {
                String string = new JSONObject(str).getString("productId");
                kotlin.jvm.internal.m.e(string, "sku");
                kotlin.jvm.internal.m.e(str, "purchase");
                map.put(string, str);
                arrayList2.add(string);
            } catch (JSONException e2) {
                Log.e(f10351b, "Error parsing in-app purchase data.", e2);
            }
        }
        i iVar = i.a;
        for (Map.Entry<String, String> entry : i.k(context, arrayList2, f10358i, z).entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String str2 = (String) map.get(key);
            if (str2 != null) {
                com.facebook.o0.q0.i iVar2 = com.facebook.o0.q0.i.a;
                com.facebook.o0.q0.i.f(str2, value, z);
            }
        }
    }

    public static final void g() {
        f fVar = a;
        fVar.e();
        if (kotlin.jvm.internal.m.a(f10353d, Boolean.FALSE)) {
            return;
        }
        com.facebook.o0.q0.i iVar = com.facebook.o0.q0.i.a;
        if (com.facebook.o0.q0.i.c()) {
            fVar.h();
        }
    }

    private final void h() {
        if (f10352c.compareAndSet(false, true)) {
            a0 a0Var = a0.a;
            Context contextC = a0.c();
            if (contextC instanceof Application) {
                Application application = (Application) contextC;
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f10356g;
                if (activityLifecycleCallbacks == null) {
                    kotlin.jvm.internal.m.w("callbacks");
                    throw null;
                }
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                Intent intent = f10357h;
                if (intent == null) {
                    kotlin.jvm.internal.m.w("intent");
                    throw null;
                }
                ServiceConnection serviceConnection = f10355f;
                if (serviceConnection != null) {
                    contextC.bindService(intent, serviceConnection, 1);
                } else {
                    kotlin.jvm.internal.m.w("serviceConnection");
                    throw null;
                }
            }
        }
    }
}
