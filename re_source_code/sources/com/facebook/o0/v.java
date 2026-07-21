package com.facebook.o0;

import android.os.Build;
import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.FacebookException;
import com.facebook.internal.p0;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10538f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashSet<String> f10539g = new HashSet<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f10540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f10541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f10542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f10543k;
    private final String l;

    /* JADX INFO: compiled from: AppEvent.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String str) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Charset charsetForName = Charset.forName("UTF-8");
                kotlin.jvm.internal.m.e(charsetForName, "Charset.forName(charsetName)");
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = str.getBytes(charsetForName);
                kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes, 0, bytes.length);
                byte[] bArrDigest = messageDigest.digest();
                kotlin.jvm.internal.m.e(bArrDigest, "digest.digest()");
                com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
                return com.facebook.o0.q0.g.c(bArrDigest);
            } catch (UnsupportedEncodingException e2) {
                p0 p0Var = p0.a;
                p0.i0("Failed to generate checksum: ", e2);
                return "1";
            } catch (NoSuchAlgorithmException e3) {
                p0 p0Var2 = p0.a;
                p0.i0("Failed to generate checksum: ", e3);
                return "0";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            boolean zContains;
            if (str != null) {
                if (!(str.length() == 0) && str.length() <= 40) {
                    synchronized (v.f10539g) {
                        zContains = v.f10539g.contains(str);
                        kotlin.u uVar = kotlin.u.a;
                    }
                    if (zContains) {
                        return;
                    }
                    if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").b(str)) {
                        synchronized (v.f10539g) {
                            v.f10539g.add(str);
                        }
                        return;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                        String str2 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1));
                        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
                        throw new FacebookException(str2);
                    }
                }
            }
            if (str == null) {
                str = "<None Provided>";
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String str3 = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
            kotlin.jvm.internal.m.e(str3, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(str3);
        }
    }

    /* JADX INFO: compiled from: AppEvent.kt */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10544f = new a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f10545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f10546h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f10547i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f10548j;

        /* JADX INFO: compiled from: AppEvent.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(String str, boolean z, boolean z2, String str2) {
            kotlin.jvm.internal.m.f(str, "jsonString");
            this.f10545g = str;
            this.f10546h = z;
            this.f10547i = z2;
            this.f10548j = str2;
        }

        private final Object readResolve() throws ObjectStreamException, JSONException {
            return new v(this.f10545g, this.f10546h, this.f10547i, this.f10548j, null);
        }
    }

    public v(String str, String str2, Double d2, Bundle bundle, boolean z, boolean z2, UUID uuid) throws JSONException, FacebookException {
        kotlin.jvm.internal.m.f(str, "contextName");
        kotlin.jvm.internal.m.f(str2, "eventName");
        this.f10541i = z;
        this.f10542j = z2;
        this.f10543k = str2;
        this.f10540h = d(str, str2, d2, bundle, uuid);
        this.l = b();
    }

    public /* synthetic */ v(String str, boolean z, boolean z2, String str2, kotlin.jvm.internal.g gVar) {
        this(str, z, z2, str2);
    }

    private final String b() {
        if (Build.VERSION.SDK_INT > 19) {
            a aVar = f10538f;
            String string = this.f10540h.toString();
            kotlin.jvm.internal.m.e(string, "jsonObject.toString()");
            return aVar.c(string);
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> itKeys = this.f10540h.keys();
        while (itKeys.hasNext()) {
            arrayList.add(itKeys.next());
        }
        kotlin.collections.y.x(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            sb.append(str);
            sb.append(" = ");
            sb.append(this.f10540h.optString(str));
            sb.append('\n');
        }
        a aVar2 = f10538f;
        String string2 = sb.toString();
        kotlin.jvm.internal.m.e(string2, "sb.toString()");
        return aVar2.c(string2);
    }

    private final JSONObject d(String str, String str2, Double d2, Bundle bundle, UUID uuid) throws JSONException {
        a aVar = f10538f;
        aVar.d(str2);
        JSONObject jSONObject = new JSONObject();
        com.facebook.o0.t0.a aVar2 = com.facebook.o0.t0.a.a;
        String strE = com.facebook.o0.t0.a.e(str2);
        jSONObject.put("_eventName", strE);
        jSONObject.put("_eventName_md5", aVar.c(strE));
        jSONObject.put("_logTime", System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map<String, String> mapI = i(bundle);
            for (String str3 : mapI.keySet()) {
                jSONObject.put(str3, mapI.get(str3));
            }
        }
        if (d2 != null) {
            jSONObject.put("_valueToSum", d2.doubleValue());
        }
        if (this.f10542j) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.f10541i) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            com.facebook.internal.j0.a aVar3 = com.facebook.internal.j0.a;
            com.facebook.g0 g0Var = com.facebook.g0.APP_EVENTS;
            String string = jSONObject.toString();
            kotlin.jvm.internal.m.e(string, "eventObject.toString()");
            aVar3.c(g0Var, "AppEvents", "Created app event '%s'", string);
        }
        return jSONObject;
    }

    private final Map<String, String> i(Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            a aVar = f10538f;
            kotlin.jvm.internal.m.e(str, RoomNotification.KEY);
            aVar.d(str);
            Object obj = bundle.get(str);
            if (!(obj instanceof String) && !(obj instanceof Number)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String str2 = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, str}, 2));
                kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
                throw new FacebookException(str2);
            }
            map.put(str, obj.toString());
        }
        com.facebook.o0.p0.a aVar2 = com.facebook.o0.p0.a.a;
        com.facebook.o0.p0.a.c(map);
        com.facebook.o0.t0.a aVar3 = com.facebook.o0.t0.a.a;
        com.facebook.o0.t0.a.f(map, this.f10543k);
        com.facebook.o0.n0.a aVar4 = com.facebook.o0.n0.a.a;
        com.facebook.o0.n0.a.c(map, this.f10543k);
        return map;
    }

    private final Object writeReplace() throws ObjectStreamException {
        String string = this.f10540h.toString();
        kotlin.jvm.internal.m.e(string, "jsonObject.toString()");
        return new b(string, this.f10541i, this.f10542j, this.l);
    }

    public final boolean c() {
        return this.f10541i;
    }

    public final JSONObject e() {
        return this.f10540h;
    }

    public final String f() {
        return this.f10543k;
    }

    public final boolean g() {
        if (this.l == null) {
            return true;
        }
        return kotlin.jvm.internal.m.a(b(), this.l);
    }

    public final boolean h() {
        return this.f10541i;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.f10540h.optString("_eventName"), Boolean.valueOf(this.f10541i), this.f10540h.toString()}, 3));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        return str;
    }

    private v(String str, boolean z, boolean z2, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.f10540h = jSONObject;
        this.f10541i = z;
        String strOptString = jSONObject.optString("_eventName");
        kotlin.jvm.internal.m.e(strOptString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.f10543k = strOptString;
        this.l = str2;
        this.f10542j = z2;
    }
}
