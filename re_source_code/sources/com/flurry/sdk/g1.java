package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<e1> f10779c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<String> f10781e;
    private static List<h1> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends h1>, e1> f10778b = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends h1>, h1> f10780d = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        f10781e = arrayList;
        arrayList.add("com.flurry.android.marketing.core.FlurryMarketingCoreModule");
        f10781e.add("com.flurry.android.marketing.FlurryMarketingModule");
        f10781e.add("com.flurry.android.config.killswitch.FlurryKillSwitchModule");
        f10781e.add("com.flurry.android.nativecrash.FlurryNativeCrashModule");
        f10781e.add("com.flurry.android.nativecrash.internal.FlurryNativeCrashModuleStreamingImpl");
        f10781e.add("com.flurry.android.FlurryAdModule");
        f10781e.add("com.flurry.android.ymadlite.YahooAdModule");
    }

    public static void a(Context context) {
        ArrayList<e1> arrayList;
        d1.c(3, "FlurryModuleManager", "Init Ads");
        Map<Class<? extends h1>, e1> map = f10778b;
        synchronized (map) {
            arrayList = new ArrayList(map.values());
            f10779c = arrayList;
        }
        for (e1 e1Var : arrayList) {
            d1.c(5, "FlurryModuleManager", "registration ".concat(String.valueOf(e1Var)));
            try {
                Class<? extends h1> cls = e1Var.a;
                if (cls != null && Build.VERSION.SDK_INT >= e1Var.f10716b) {
                    h1 h1VarNewInstance = cls.newInstance();
                    h1VarNewInstance.a(context);
                    f10780d.put(e1Var.a, h1VarNewInstance);
                }
            } catch (Exception e2) {
                d1.d(5, "FlurryModuleManager", "Flurry Module for class " + e1Var.a + " is not available:", e2);
            }
        }
    }

    public static void b(h1 h1Var) {
        d1.c(3, "FlurryModuleManager", "Register Add-On ".concat(String.valueOf(h1Var)));
        if (h1Var == null) {
            d1.c(5, "FlurryModuleManager", "Module is null, cannot register it");
            return;
        }
        boolean z = false;
        Iterator<h1> it = a.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().getSimpleName().equals(h1Var.getClass().getSimpleName())) {
                z = true;
                break;
            }
        }
        if (!z) {
            a.add(h1Var);
            return;
        }
        d1.c(3, "FlurryModuleManager", h1Var + " has been register already as addOn module");
    }

    public static void c(Class<? extends h1> cls) {
        d1.c(3, "FlurryModuleManager", "Register Ads ".concat(String.valueOf(cls)));
        if (cls == null) {
            return;
        }
        Map<Class<? extends h1>, e1> map = f10778b;
        synchronized (map) {
            map.put(cls, new e1(cls));
        }
    }

    public static void d(Context context) {
        d1.c(2, "FlurryModuleManager", "Init Add on modules");
        synchronized (f10780d) {
            for (h1 h1Var : a) {
                try {
                    d1.c(2, "FlurryModuleManager", "Module list: ".concat(String.valueOf(h1Var)));
                    Map<Class<? extends h1>, h1> map = f10780d;
                    if (map.containsKey(h1Var.getClass())) {
                        d1.c(5, "FlurryModuleManager", h1Var.getClass() + " has been initialized");
                    } else {
                        h1Var.a(context);
                        map.put((Class<? extends h1>) h1Var.getClass(), h1Var);
                        d1.c(3, "FlurryModuleManager", "Initialized modules: " + h1Var.getClass());
                    }
                } catch (da e2) {
                    d1.j("FlurryModuleManager", e2.getMessage());
                }
            }
        }
    }
}
