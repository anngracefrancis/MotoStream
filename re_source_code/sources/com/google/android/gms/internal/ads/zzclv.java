package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclv implements zzcjz<zzams, zzcla> {
    private final zzclc a;

    public zzclv(zzclc zzclcVar) {
        this.a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzams, zzcla> a(String str, JSONObject jSONObject) throws Throwable {
        zzams zzamsVarE = this.a.e(str, jSONObject);
        if (zzamsVarE == null) {
            return null;
        }
        return new zzcjy<>(zzamsVarE, new zzcla(), str);
    }
}
