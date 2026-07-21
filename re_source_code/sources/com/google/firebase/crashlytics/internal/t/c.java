package com.google.firebase.crashlytics.internal.t;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.y;
import com.google.firebase.crashlytics.internal.q.a;
import com.google.firebase.crashlytics.internal.q.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultSettingsSpiCall.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements k {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f19543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f19544c;

    public c(String str, b bVar) {
        this(str, bVar, h.f());
    }

    private a b(a aVar, j jVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", jVar.a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", y.i());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", jVar.f19567b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", jVar.f19568c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", jVar.f19569d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", jVar.f19570e.a().c());
        return aVar;
    }

    private void c(a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            this.f19544c.l("Failed to parse settings JSON from " + this.a, e2);
            this.f19544c.k("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> f(j jVar) {
        HashMap map = new HashMap();
        map.put("build_version", jVar.f19573h);
        map.put("display_version", jVar.f19572g);
        map.put("source", Integer.toString(jVar.f19574i));
        String str = jVar.f19571f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    @Override // com.google.firebase.crashlytics.internal.t.k
    public JSONObject a(j jVar, boolean z) {
        if (!z) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map<String, String> mapF = f(jVar);
            a aVarB = b(d(mapF), jVar);
            this.f19544c.b("Requesting settings from " + this.a);
            this.f19544c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e2) {
            this.f19544c.e("Settings request failed.", e2);
            return null;
        }
    }

    protected a d(Map<String, String> map) {
        return this.f19543b.a(this.a, map).d("User-Agent", "Crashlytics Android SDK/" + y.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject g(com.google.firebase.crashlytics.internal.q.c cVar) {
        int iB = cVar.b();
        this.f19544c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f19544c.d("Settings request failed; (status: " + iB + ") from " + this.a);
        return null;
    }

    boolean h(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 202 || i2 == 203;
    }

    c(String str, b bVar, h hVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f19544c = hVar;
        this.f19543b = bVar;
        this.a = str;
    }
}
