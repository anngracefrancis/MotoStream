package com.facebook.o0.n0;

import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import com.facebook.o0.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventDeactivationManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10341b;
    public static final a a = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<C0149a> f10342c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f10343d = new HashSet();

    /* JADX INFO: renamed from: com.facebook.o0.n0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventDeactivationManager.kt */
    public static final class C0149a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f10344b;

        public C0149a(String str, List<String> list) {
            m.f(str, "eventName");
            m.f(list, "deprecateParams");
            this.a = str;
            this.f10344b = list;
        }

        public final List<String> a() {
            return this.f10344b;
        }

        public final String b() {
            return this.a;
        }

        public final void c(List<String> list) {
            m.f(list, "<set-?>");
            this.f10344b = list;
        }
    }

    private a() {
    }

    public static final void a() {
        a aVar = a;
        f10341b = true;
        aVar.b();
    }

    private final synchronized void b() {
        try {
            d0 d0Var = d0.a;
            a0 a0Var = a0.a;
            c0 c0VarO = d0.o(a0.d(), false);
            if (c0VarO == null) {
                return;
            }
            String strI = c0VarO.i();
            if (strI != null) {
                if (strI.length() > 0) {
                    JSONObject jSONObject = new JSONObject(strI);
                    f10342c.clear();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        if (jSONObject2 != null) {
                            if (jSONObject2.optBoolean("is_deprecated_event")) {
                                Set<String> set = f10343d;
                                m.e(next, RoomNotification.KEY);
                                set.add(next);
                            } else {
                                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                m.e(next, RoomNotification.KEY);
                                C0149a c0149a = new C0149a(next, new ArrayList());
                                if (jSONArrayOptJSONArray != null) {
                                    p0 p0Var = p0.a;
                                    c0149a.c(p0.k(jSONArrayOptJSONArray));
                                }
                                f10342c.add(c0149a);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final void c(Map<String, String> map, String str) {
        m.f(map, "parameters");
        m.f(str, "eventName");
        if (f10341b) {
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            for (C0149a c0149a : new ArrayList(f10342c)) {
                if (m.a(c0149a.b(), str)) {
                    for (String str2 : arrayList) {
                        if (c0149a.a().contains(str2)) {
                            map.remove(str2);
                        }
                    }
                }
            }
        }
    }

    public static final void d(List<v> list) {
        m.f(list, "events");
        if (f10341b) {
            Iterator<v> it = list.iterator();
            while (it.hasNext()) {
                if (f10343d.contains(it.next().f())) {
                    it.remove();
                }
            }
        }
    }
}
