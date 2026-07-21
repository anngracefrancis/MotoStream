package com.google.firebase.crashlytics.internal.t;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.d0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SettingsJsonParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final d0 a;

    g(d0 d0Var) {
        this.a = d0Var;
    }

    private static h a(int i2) {
        if (i2 == 3) {
            return new l();
        }
        h.f().d("Could not determine SettingsJsonTransform for settings version " + i2 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.a, jSONObject);
    }
}
