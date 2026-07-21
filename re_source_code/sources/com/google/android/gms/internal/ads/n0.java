package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class n0 implements zzahw {
    private final /* synthetic */ zzbbr a;

    n0(zzahu zzahuVar, zzbbr zzbbrVar) {
        this.a = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzahw
    public final void onFailure(String str) {
        this.a.c(new zzali(str));
    }
}
