package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbd {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcau f15009b;

    public zzcbd(Executor executor, zzcau zzcauVar) {
        this.a = executor;
        this.f15009b = zzcauVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    public final zzbbh<List<zzcbg>> a(JSONObject jSONObject, String str) {
        Future futureO;
        final String strOptString;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return zzbar.o(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("name")) == null) {
                futureO = zzbar.o(null);
            } else {
                String strOptString2 = jSONObjectOptJSONObject.optString("type");
                char c2 = "string".equals(strOptString2) ? (char) 1 : "image".equals(strOptString2) ? (char) 2 : (char) 0;
                if (c2 == 1) {
                    futureO = zzbar.o(new zzcbg(strOptString, jSONObjectOptJSONObject.optString("string_value")));
                } else if (c2 != 2) {
                    futureO = zzbar.o(null);
                } else {
                    futureO = zzbar.d(this.f15009b.g(jSONObjectOptJSONObject, "image_value"), new zzbam(strOptString) { // from class: com.google.android.gms.internal.ads.wg
                        private final String a;

                        {
                            this.a = strOptString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbam
                        public final Object a(Object obj) {
                            return new zzcbg(this.a, (zzadw) obj);
                        }
                    }, this.a);
                }
            }
            arrayList.add(futureO);
        }
        return zzbar.d(zzbar.m(arrayList), vg.a, this.a);
    }
}
