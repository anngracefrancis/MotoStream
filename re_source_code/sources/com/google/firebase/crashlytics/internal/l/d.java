package com.google.firebase.crashlytics.internal.l;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.m.a;
import com.google.firebase.crashlytics.internal.m.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BreadcrumbAnalyticsEventReceiver.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements b, b {
    private a a;

    private static String b(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.l.b
    public void J0(String str, Bundle bundle) {
        a aVar = this.a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                h.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.m.b
    public void a(a aVar) {
        this.a = aVar;
        h.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }
}
