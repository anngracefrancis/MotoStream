package com.facebook.o0.o0;

import android.content.SharedPreferences;
import com.facebook.a0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.q0;
import kotlin.text.v;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppPurchaseLoggerManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f10376b;
    public static final j a = new j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f10377c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Long> f10378d = new ConcurrentHashMap();

    private j() {
    }

    public static final boolean d() {
        a.g();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = f10376b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.m.w("sharedPreferences");
            throw null;
        }
        long j2 = sharedPreferences.getLong("LAST_QUERY_PURCHASE_HISTORY_TIME", 0L);
        if (j2 != 0 && jCurrentTimeMillis - j2 < 86400) {
            return false;
        }
        SharedPreferences sharedPreferences2 = f10376b;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putLong("LAST_QUERY_PURCHASE_HISTORY_TIME", jCurrentTimeMillis).apply();
            return true;
        }
        kotlin.jvm.internal.m.w("sharedPreferences");
        throw null;
    }

    public static final void e(Map<String, JSONObject> map, Map<String, ? extends JSONObject> map2) {
        kotlin.jvm.internal.m.f(map, "purchaseDetailsMap");
        kotlin.jvm.internal.m.f(map2, "skuDetailsMap");
        j jVar = a;
        jVar.g();
        jVar.f(jVar.c(jVar.a(map), map2));
    }

    private final void f(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                com.facebook.o0.q0.i iVar = com.facebook.o0.q0.i.a;
                com.facebook.o0.q0.i.f(key, value, false);
            }
        }
    }

    private final void g() {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        SharedPreferences sharedPreferences2 = a0.c().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
        if (sharedPreferences.contains("LAST_CLEARED_TIME")) {
            sharedPreferences.edit().clear().apply();
            sharedPreferences2.edit().clear().apply();
        }
        SharedPreferences sharedPreferences3 = a0.c().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0);
        kotlin.jvm.internal.m.e(sharedPreferences3, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
        f10376b = sharedPreferences3;
        Set<String> set = f10377c;
        if (sharedPreferences3 == null) {
            kotlin.jvm.internal.m.w("sharedPreferences");
            throw null;
        }
        Set<String> stringSet = sharedPreferences3.getStringSet("PURCHASE_DETAILS_SET", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        set.addAll(stringSet);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            List listV0 = v.v0(it.next(), new String[]{";"}, false, 2, 2, null);
            f10378d.put((String) listV0.get(0), Long.valueOf(Long.parseLong((String) listV0.get(1))));
        }
        b();
    }

    public final Map<String, JSONObject> a(Map<String, JSONObject> map) {
        kotlin.jvm.internal.m.f(map, "purchaseDetailsMap");
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (Map.Entry entry : q0.s(map).entrySet()) {
            String str = (String) entry.getKey();
            JSONObject jSONObject = (JSONObject) entry.getValue();
            try {
                if (jSONObject.has("purchaseToken")) {
                    String string = jSONObject.getString("purchaseToken");
                    if (f10378d.containsKey(string)) {
                        map.remove(str);
                    } else {
                        Set<String> set = f10377c;
                        StringBuilder sb = new StringBuilder();
                        sb.append((Object) string);
                        sb.append(';');
                        sb.append(jCurrentTimeMillis);
                        set.add(sb.toString());
                    }
                }
            } catch (Exception unused) {
            }
        }
        SharedPreferences sharedPreferences = f10376b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putStringSet("PURCHASE_DETAILS_SET", f10377c).apply();
            return new HashMap(map);
        }
        kotlin.jvm.internal.m.w("sharedPreferences");
        throw null;
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = f10376b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.m.w("sharedPreferences");
            throw null;
        }
        long j2 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
        if (j2 == 0) {
            SharedPreferences sharedPreferences2 = f10376b;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                return;
            } else {
                kotlin.jvm.internal.m.w("sharedPreferences");
                throw null;
            }
        }
        if (jCurrentTimeMillis - j2 > 604800) {
            for (Map.Entry entry : q0.s(f10378d).entrySet()) {
                String str = (String) entry.getKey();
                long jLongValue = ((Number) entry.getValue()).longValue();
                if (jCurrentTimeMillis - jLongValue > 86400) {
                    f10377c.remove(str + ';' + jLongValue);
                    f10378d.remove(str);
                }
            }
            SharedPreferences sharedPreferences3 = f10376b;
            if (sharedPreferences3 == null) {
                kotlin.jvm.internal.m.w("sharedPreferences");
                throw null;
            }
            sharedPreferences3.edit().putStringSet("PURCHASE_DETAILS_SET", f10377c).putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
        }
    }

    public final Map<String, String> c(Map<String, ? extends JSONObject> map, Map<String, ? extends JSONObject> map2) {
        kotlin.jvm.internal.m.f(map, "purchaseDetailsMap");
        kotlin.jvm.internal.m.f(map2, "skuDetailsMap");
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends JSONObject> entry : map.entrySet()) {
            String key = entry.getKey();
            JSONObject value = entry.getValue();
            JSONObject jSONObject = map2.get(key);
            if (value != null && value.has("purchaseTime")) {
                try {
                    if (jCurrentTimeMillis - (value.getLong("purchaseTime") / 1000) <= 86400 && jSONObject != null) {
                        String string = value.toString();
                        kotlin.jvm.internal.m.e(string, "purchaseDetail.toString()");
                        String string2 = jSONObject.toString();
                        kotlin.jvm.internal.m.e(string2, "skuDetail.toString()");
                        linkedHashMap.put(string, string2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return linkedHashMap;
    }
}
