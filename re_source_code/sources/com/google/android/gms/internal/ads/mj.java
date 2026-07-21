package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class mj implements zzczc {
    static final zzczc a = new mj();

    private mj() {
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final Object a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzawz.m("Ad request signals:");
        zzawz.m(jSONObject.toString(2));
        return jSONObject;
    }
}
