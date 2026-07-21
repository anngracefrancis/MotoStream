package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbye implements zzdti<JSONObject> {
    private final zzbyc a;

    public zzbye(zzbyc zzbycVar) {
        this.a = zzbycVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (JSONObject) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
