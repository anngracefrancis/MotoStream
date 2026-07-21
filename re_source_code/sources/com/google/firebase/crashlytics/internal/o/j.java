package com.google.firebase.crashlytics.internal.o;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.encoders.a;
import com.google.firebase.encoders.json.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RolloutAssignment.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class j {
    public static final a a = new d().g(b.a).f();

    static j a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static j b(String str, String str2, String str3, String str4, long j2) {
        return new c(str, str2, i(str3), str4, j2);
    }

    private static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public f0.e.d.AbstractC0226e h() {
        return f0.e.d.AbstractC0226e.a().d(f0.e.d.AbstractC0226e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
