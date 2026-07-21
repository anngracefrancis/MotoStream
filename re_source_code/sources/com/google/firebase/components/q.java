package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ComponentDiscovery.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> {
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<T> f18898b;

    /* JADX INFO: compiled from: ComponentDiscovery.java */
    private static class b implements c<Context> {
        private final Class<? extends Service> a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.q.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private b(Class<? extends Service> cls) {
            this.a = cls;
        }
    }

    /* JADX INFO: compiled from: ComponentDiscovery.java */
    interface c<T> {
        List<String> a(T t);
    }

    q(T t, c<T> cVar) {
        this.a = t;
        this.f18898b = cVar;
    }

    public static q<Context> b(Context context, Class<? extends Service> cls) {
        return new q<>(context, new b(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComponentRegistrar c(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e2) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e2);
        } catch (InstantiationException e3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e3);
        } catch (NoSuchMethodException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e4);
        } catch (InvocationTargetException e5) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e5);
        }
    }

    public List<com.google.firebase.s.b<ComponentRegistrar>> a() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f18898b.a(this.a)) {
            arrayList.add(new com.google.firebase.s.b() { // from class: com.google.firebase.components.c
                @Override // com.google.firebase.s.b
                public final Object get() {
                    return q.c(str);
                }
            });
        }
        return arrayList;
    }
}
