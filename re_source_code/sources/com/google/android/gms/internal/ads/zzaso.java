package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaso implements zzasb {
    private zzalj<JSONObject, JSONObject> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzalj<JSONObject, JSONObject> f14144b;

    public zzaso(Context context) {
        zzalr zzalrVarA = zzk.zzlt().a(context, zzbai.y());
        zzaln<JSONObject> zzalnVar = zzalo.f13955b;
        this.a = zzalrVarA.a("google.afma.request.getAdDictionary", zzalnVar, zzalnVar);
        this.f14144b = zzk.zzlt().a(context, zzbai.y()).a("google.afma.sdkConstants.getSdkConstants", zzalnVar, zzalnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasb
    public final zzalj<JSONObject, JSONObject> a() {
        return this.f14144b;
    }
}
