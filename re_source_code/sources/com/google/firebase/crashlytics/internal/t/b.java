package com.google.firebase.crashlytics.internal.t;

import com.google.firebase.crashlytics.internal.n.d0;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultSettingsJsonTransform.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements h {
    b() {
    }

    static d b(d0 d0Var) {
        return new d(((long) 3600000) + d0Var.a(), new d.b(8, 4), new d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // com.google.firebase.crashlytics.internal.t.h
    public d a(d0 d0Var, JSONObject jSONObject) {
        return b(d0Var);
    }
}
