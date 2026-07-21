package com.facebook.o0.u0;

import android.content.SharedPreferences;
import android.view.View;
import cm.aptoide.pt.root.execution.Command;
import com.facebook.a0;
import com.facebook.internal.p0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PredictionHistoryManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SharedPreferences f10521c;
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f10520b = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f10522d = new AtomicBoolean(false);

    private f() {
    }

    public static final void a(String str, String str2) {
        m.f(str, "pathID");
        m.f(str2, "predictedEvent");
        if (!f10522d.get()) {
            a.c();
        }
        Map<String, String> map = f10520b;
        map.put(str, str2);
        SharedPreferences sharedPreferences = f10521c;
        if (sharedPreferences == null) {
            m.w("shardPreferences");
            throw null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        p0 p0Var = p0.a;
        editorEdit.putString("SUGGESTED_EVENTS_HISTORY", p0.l0(q0.s(map))).apply();
    }

    public static final String b(View view, String str) {
        m.f(view, "view");
        m.f(str, Command.CommandHandler.TEXT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Command.CommandHandler.TEXT, str);
            JSONArray jSONArray = new JSONArray();
            while (view != null) {
                jSONArray.put(view.getClass().getSimpleName());
                com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
                view = com.facebook.o0.m0.n.f.j(view);
            }
            jSONObject.put("classname", jSONArray);
        } catch (JSONException unused) {
        }
        p0 p0Var = p0.a;
        return p0.F0(jSONObject.toString());
    }

    private final void c() {
        AtomicBoolean atomicBoolean = f10522d;
        if (atomicBoolean.get()) {
            return;
        }
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
        m.e(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(CLICKED_PATH_STORE, Context.MODE_PRIVATE)");
        f10521c = sharedPreferences;
        Map<String, String> map = f10520b;
        p0 p0Var = p0.a;
        SharedPreferences sharedPreferences2 = f10521c;
        if (sharedPreferences2 == null) {
            m.w("shardPreferences");
            throw null;
        }
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        String string = sharedPreferences2.getString("SUGGESTED_EVENTS_HISTORY", HttpUrl.FRAGMENT_ENCODE_SET);
        if (string != null) {
            str = string;
        }
        map.putAll(p0.f0(str));
        atomicBoolean.set(true);
    }

    public static final String d(String str) {
        m.f(str, "pathID");
        Map<String, String> map = f10520b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }
}
