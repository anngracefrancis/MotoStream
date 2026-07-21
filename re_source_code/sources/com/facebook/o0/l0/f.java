package com.facebook.o0.l0;

import android.content.SharedPreferences;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.d0;
import com.facebook.e0;
import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.s;
import kotlin.text.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppEventsCAPIManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10177b = f.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10178c;

    private f() {
    }

    public static final void a() {
        try {
            a aVar = new GraphRequest.b() { // from class: com.facebook.o0.l0.a
                @Override // com.facebook.GraphRequest.b
                public final void b(d0 d0Var) {
                    f.b(d0Var);
                }
            };
            a0 a0Var = a0.a;
            GraphRequest graphRequest = new GraphRequest(null, kotlin.jvm.internal.m.n(a0.d(), "/cloudbridge_settings"), null, e0.GET, aVar, null, 32, null);
            j0.a aVar2 = j0.a;
            g0 g0Var = g0.APP_EVENTS;
            String str = f10177b;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            aVar2.c(g0Var, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
            graphRequest.k();
        } catch (JSONException e2) {
            j0.a aVar3 = j0.a;
            g0 g0Var2 = g0.APP_EVENTS;
            String str2 = f10177b;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            aVar3.c(g0Var2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", kotlin.b.b(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "response");
        a.c(d0Var);
    }

    public static final Map<String, Object> d() {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return null;
        }
        o oVar = o.DATASETID;
        String string = sharedPreferences.getString(oVar.k(), null);
        o oVar2 = o.URL;
        String string2 = sharedPreferences.getString(oVar2.k(), null);
        o oVar3 = o.ACCESSKEY;
        String string3 = sharedPreferences.getString(oVar3.k(), null);
        if (string == null || u.t(string)) {
            return null;
        }
        if (string2 == null || u.t(string2)) {
            return null;
        }
        if (string3 == null || u.t(string3)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(oVar2.k(), string2);
        linkedHashMap.put(oVar.k(), string);
        linkedHashMap.put(oVar3.k(), string3);
        j0.a.c(g0.APP_EVENTS, f10177b.toString(), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
        return linkedHashMap;
    }

    public final void c(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "response");
        boolean zBooleanValue = false;
        if (d0Var.b() != null) {
            j0.a aVar = j0.a;
            g0 g0Var = g0.APP_EVENTS;
            String str = f10177b;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            aVar.c(g0Var, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", d0Var.b().toString(), String.valueOf(d0Var.b().e()));
            Map<String, Object> mapD = d();
            if (mapD != null) {
                URL url = new URL(String.valueOf(mapD.get(o.URL.k())));
                h hVar = h.a;
                h.c(String.valueOf(mapD.get(o.DATASETID.k())), url.getProtocol() + "://" + ((Object) url.getHost()), String.valueOf(mapD.get(o.ACCESSKEY.k())));
                f10178c = true;
                return;
            }
            return;
        }
        j0.a aVar2 = j0.a;
        g0 g0Var2 = g0.APP_EVENTS;
        String str2 = f10177b;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        aVar2.c(g0Var2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", d0Var);
        JSONObject jSONObjectC = d0Var.c();
        try {
            p0 p0Var = p0.a;
            Object obj = jSONObjectC == null ? null : jSONObjectC.get("data");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            Map<String, ? extends Object> mapL = p0.l(new JSONObject((String) s.W(p0.k((JSONArray) obj))));
            String str3 = (String) mapL.get(o.URL.k());
            String str4 = (String) mapL.get(o.DATASETID.k());
            String str5 = (String) mapL.get(o.ACCESSKEY.k());
            if (str3 == null || str4 == null || str5 == null) {
                kotlin.jvm.internal.m.e(str2, "TAG");
                aVar2.b(g0Var2, str2, "CloudBridge Settings API response doesn't have valid data");
                return;
            }
            try {
                h hVar2 = h.a;
                h.c(str4, str3, str5);
                g(mapL);
                o oVar = o.ENABLED;
                if (mapL.get(oVar.k()) != null) {
                    Object obj2 = mapL.get(oVar.k());
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    zBooleanValue = ((Boolean) obj2).booleanValue();
                }
                f10178c = zBooleanValue;
            } catch (MalformedURLException e2) {
                j0.a aVar3 = j0.a;
                g0 g0Var3 = g0.APP_EVENTS;
                String str6 = f10177b;
                kotlin.jvm.internal.m.e(str6, "TAG");
                aVar3.c(g0Var3, str6, "CloudBridge Settings API response doesn't have valid url\n %s ", kotlin.b.b(e2));
            }
        } catch (NullPointerException e3) {
            j0.a aVar4 = j0.a;
            g0 g0Var4 = g0.APP_EVENTS;
            String str7 = f10177b;
            kotlin.jvm.internal.m.e(str7, "TAG");
            aVar4.c(g0Var4, str7, "CloudBridge Settings API response is not a valid json: \n%s ", kotlin.b.b(e3));
        } catch (JSONException e4) {
            j0.a aVar5 = j0.a;
            g0 g0Var5 = g0.APP_EVENTS;
            String str8 = f10177b;
            kotlin.jvm.internal.m.e(str8, "TAG");
            aVar5.c(g0Var5, str8, "CloudBridge Settings API response is not a valid json: \n%s ", kotlin.b.b(e4));
        }
    }

    public final boolean e() {
        return f10178c;
    }

    public final void g(Map<String, ? extends Object> map) {
        a0 a0Var = a0.a;
        SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (map == null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        o oVar = o.DATASETID;
        Object obj = map.get(oVar.k());
        o oVar2 = o.URL;
        Object obj2 = map.get(oVar2.k());
        o oVar3 = o.ACCESSKEY;
        Object obj3 = map.get(oVar3.k());
        if (obj == null || obj2 == null || obj3 == null) {
            return;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        editorEdit2.putString(oVar.k(), obj.toString());
        editorEdit2.putString(oVar2.k(), obj2.toString());
        editorEdit2.putString(oVar3.k(), obj3.toString());
        editorEdit2.apply();
        j0.a.c(g0.APP_EVENTS, f10177b.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
    }
}
