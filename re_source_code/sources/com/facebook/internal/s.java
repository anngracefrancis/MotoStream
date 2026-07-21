package com.facebook.internal;

import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BundleJSONConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final s a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, h> f9856b;

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class a implements h {
        a() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class b implements h {
        b() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class c implements h {
        c() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            bundle.putLong(str, ((Long) obj).longValue());
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class d implements h {
        d() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            bundle.putDouble(str, ((Double) obj).doubleValue());
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class e implements h {
        e() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            bundle.putString(str, (String) obj);
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class f implements h {
        f() {
        }

        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            throw new IllegalArgumentException("Unexpected type from JSON");
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public static final class g implements h {
        g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.internal.s.h
        public void a(Bundle bundle, String str, Object obj) throws JSONException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
            kotlin.jvm.internal.m.f(obj, "value");
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                return;
            }
            int i2 = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    Object obj2 = jSONArray.get(i2);
                    if (!(obj2 instanceof String)) {
                        throw new IllegalArgumentException(kotlin.jvm.internal.m.n("Unexpected type in an array: ", obj2.getClass()));
                    }
                    arrayList.add(obj2);
                    if (i3 < length) {
                        i2 = i3;
                    }
                }
            }
            bundle.putStringArrayList(str, arrayList);
        }
    }

    /* JADX INFO: compiled from: BundleJSONConverter.kt */
    public interface h {
        void a(Bundle bundle, String str, Object obj) throws JSONException;
    }

    static {
        HashMap map = new HashMap();
        f9856b = map;
        map.put(Boolean.class, new a());
        map.put(Integer.class, new b());
        map.put(Long.class, new c());
        map.put(Double.class, new d());
        map.put(String.class, new e());
        map.put(String[].class, new f());
        map.put(JSONArray.class, new g());
    }

    private s() {
    }

    public static final Bundle a(JSONObject jSONObject) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, a((JSONObject) obj));
                } else {
                    h hVar = f9856b.get(obj.getClass());
                    if (hVar == null) {
                        throw new IllegalArgumentException(kotlin.jvm.internal.m.n("Unsupported type: ", obj.getClass()));
                    }
                    kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                    kotlin.jvm.internal.m.e(obj, "value");
                    hVar.a(bundle, next, obj);
                }
            }
        }
        return bundle;
    }
}
