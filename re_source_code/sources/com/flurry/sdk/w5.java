package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f11132c;

    public w5(String str, List<String> list) {
        this.f11131b = str;
        this.f11132c = list;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f11132c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObjectA.put("fl.launch.options.key", this.f11131b);
        jSONObjectA.put("fl.launch.options.values", jSONArray);
        return jSONObjectA;
    }
}
