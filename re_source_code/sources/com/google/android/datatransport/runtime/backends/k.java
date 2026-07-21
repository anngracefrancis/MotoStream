package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: compiled from: MetadataBackendRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
@Singleton
class k implements e {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f11316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, m> f11317c;

    /* JADX INFO: compiled from: MetadataBackendRegistry.java */
    static class a {
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, String> f11318b = null;

        a(Context context) {
            this.a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        private Map<String, String> c() {
            if (this.f11318b == null) {
                this.f11318b = a(this.a);
            }
            return this.f11318b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        d b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str2).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (InstantiationException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e6);
                return null;
            }
        }
    }

    @Inject
    k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // com.google.android.datatransport.runtime.backends.e
    public synchronized m get(String str) {
        if (this.f11317c.containsKey(str)) {
            return this.f11317c.get(str);
        }
        d dVarB = this.a.b(str);
        if (dVarB == null) {
            return null;
        }
        m mVarCreate = dVarB.create(this.f11316b.a(str));
        this.f11317c.put(str, mVarCreate);
        return mVarCreate;
    }

    k(a aVar, i iVar) {
        this.f11317c = new HashMap();
        this.a = aVar;
        this.f11316b = iVar;
    }
}
