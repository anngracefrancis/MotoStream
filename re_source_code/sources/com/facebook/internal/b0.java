package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FetchedAppGateKeepersManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final b0 a = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9729b = kotlin.jvm.internal.g0.b(b0.class).q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f9730c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<a> f9731d = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, JSONObject> f9732e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Long f9733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.facebook.internal.s0.b f9734g;

    /* JADX INFO: compiled from: FetchedAppGateKeepersManager.kt */
    public interface a {
        void onCompleted();
    }

    private b0() {
    }

    private final JSONObject a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("sdk_version", com.facebook.a0.s());
        bundle.putString("fields", "gatekeepers");
        GraphRequest.c cVar = GraphRequest.a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("app/%s", Arrays.copyOf(new Object[]{"mobile_sdk_gk"}, 1));
        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
        GraphRequest graphRequestX = cVar.x(null, str2, null);
        graphRequestX.H(bundle);
        JSONObject jSONObjectD = graphRequestX.j().d();
        return jSONObjectD == null ? new JSONObject() : jSONObjectD;
    }

    public static final boolean b(String str, String str2, boolean z) {
        Boolean bool;
        kotlin.jvm.internal.m.f(str, "name");
        Map<String, Boolean> mapC = a.c(str2);
        return (mapC.containsKey(str) && (bool = mapC.get(str)) != null) ? bool.booleanValue() : z;
    }

    private final boolean d(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 3600000;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0044 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:17:0x0046 A[Catch: all -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x001a, B:10:0x0022, B:13:0x0027, B:17:0x0046, B:19:0x0059, B:24:0x006a, B:25:0x006d, B:29:0x0077, B:33:0x0081, B:22:0x0061), top: B:39:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x006a A[Catch: all -> 0x008b, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x001a, B:10:0x0022, B:13:0x0027, B:17:0x0046, B:19:0x0059, B:24:0x006a, B:25:0x006d, B:29:0x0077, B:33:0x0081, B:22:0x0061), top: B:39:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:29:0x0077 A[Catch: all -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x001a, B:10:0x0022, B:13:0x0027, B:17:0x0046, B:19:0x0059, B:24:0x006a, B:25:0x006d, B:29:0x0077, B:33:0x0081, B:22:0x0061), top: B:39:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007f A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:33:0x0081 A[Catch: all -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x001a, B:10:0x0022, B:13:0x0027, B:17:0x0046, B:19:0x0059, B:24:0x006a, B:25:0x006d, B:29:0x0077, B:33:0x0081, B:22:0x0061), top: B:39:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x0044, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0075, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x007f, please report this as an issue */
    public static final synchronized void h(a aVar) {
        final String strD;
        b0 b0Var;
        final Context contextC;
        final String str;
        JSONObject jSONObject;
        String string;
        Executor executorK;
        if (aVar == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            strD = com.facebook.a0.d();
            b0Var = a;
            if (!b0Var.d(f9733f)) {
            }
            contextC = com.facebook.a0.c();
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            str = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{strD}, 1));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
            if (contextC == null) {
                return;
            }
            jSONObject = null;
            string = contextC.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(str, null);
            p0 p0Var = p0.a;
            if (!p0.a0(string)) {
                jSONObject = new JSONObject(string);
                if (jSONObject != null) {
                    j(strD, jSONObject);
                }
            }
            com.facebook.a0 a0Var2 = com.facebook.a0.a;
            executorK = com.facebook.a0.k();
            if (executorK == null) {
                return;
            }
            if (f9730c.compareAndSet(false, true)) {
                executorK.execute(new Runnable() { // from class: com.facebook.internal.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.i(strD, contextC, str);
                    }
                });
                return;
            }
            return;
        }
        f9731d.add(aVar);
        com.facebook.a0 a0Var3 = com.facebook.a0.a;
        strD = com.facebook.a0.d();
        b0Var = a;
        if (!b0Var.d(f9733f) && f9732e.containsKey(strD)) {
            b0Var.k();
            return;
        }
        contextC = com.facebook.a0.c();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        str = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{strD}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        if (contextC == null) {
            return;
        }
        jSONObject = null;
        string = contextC.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(str, null);
        p0 p0Var2 = p0.a;
        if (!p0.a0(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e2) {
                p0 p0Var3 = p0.a;
                p0.i0("FacebookSDK", e2);
            }
            if (jSONObject != null) {
                j(strD, jSONObject);
            }
        }
        com.facebook.a0 a0Var4 = com.facebook.a0.a;
        executorK = com.facebook.a0.k();
        if (executorK == null) {
            return;
        }
        if (f9730c.compareAndSet(false, true)) {
            return;
        }
        executorK.execute(new Runnable() { // from class: com.facebook.internal.e
            @Override // java.lang.Runnable
            public final void run() {
                b0.i(strD, contextC, str);
            }
        });
        return;
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, Context context, String str2) {
        kotlin.jvm.internal.m.f(str, "$applicationId");
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(str2, "$gateKeepersKey");
        b0 b0Var = a;
        JSONObject jSONObjectA = b0Var.a(str);
        if (jSONObjectA.length() != 0) {
            j(str, jSONObjectA);
            context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str2, jSONObjectA.toString()).apply();
            f9733f = Long.valueOf(System.currentTimeMillis());
        }
        b0Var.k();
        f9730c.set(false);
    }

    public static final synchronized JSONObject j(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        kotlin.jvm.internal.m.f(str, "applicationId");
        jSONObject2 = f9732e.get(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        int i2 = 0;
        JSONObject jSONObjectOptJSONObject = null;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null) {
            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        }
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("gatekeepers");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        int length = jSONArrayOptJSONArray2.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    jSONObject2.put(jSONObject3.getString(RoomNotification.KEY), jSONObject3.getBoolean("value"));
                } catch (JSONException e2) {
                    p0 p0Var = p0.a;
                    p0.i0("FacebookSDK", e2);
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        f9732e.put(str, jSONObject2);
        return jSONObject2;
    }

    private final void k() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<a> concurrentLinkedQueue = f9731d;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final a aVarPoll = concurrentLinkedQueue.poll();
            if (aVarPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.l(aVarPoll);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(a aVar) {
        aVar.onCompleted();
    }

    public static final JSONObject m(String str, boolean z) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        if (!z) {
            Map<String, JSONObject> map = f9732e;
            if (map.containsKey(str)) {
                JSONObject jSONObject = map.get(str);
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        }
        JSONObject jSONObjectA = a.a(str);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context contextC = com.facebook.a0.c();
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str2 = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{str}, 1));
        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
        contextC.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str2, jSONObjectA.toString()).apply();
        return j(str, jSONObjectA);
    }

    public final Map<String, Boolean> c(String str) {
        g();
        if (str != null) {
            Map<String, JSONObject> map = f9732e;
            if (map.containsKey(str)) {
                com.facebook.internal.s0.b bVar = f9734g;
                List<com.facebook.internal.s0.a> listA = bVar == null ? null : bVar.a(str);
                if (listA != null) {
                    HashMap map2 = new HashMap();
                    for (com.facebook.internal.s0.a aVar : listA) {
                        map2.put(aVar.a(), Boolean.valueOf(aVar.b()));
                    }
                    return map2;
                }
                HashMap map3 = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                    map3.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                com.facebook.internal.s0.b bVar2 = f9734g;
                if (bVar2 == null) {
                    bVar2 = new com.facebook.internal.s0.b();
                }
                ArrayList arrayList = new ArrayList(map3.size());
                for (Map.Entry entry : map3.entrySet()) {
                    arrayList.add(new com.facebook.internal.s0.a((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                bVar2.b(str, arrayList);
                f9734g = bVar2;
                return map3;
            }
        }
        return new HashMap();
    }

    public final void g() {
        h(null);
    }
}
