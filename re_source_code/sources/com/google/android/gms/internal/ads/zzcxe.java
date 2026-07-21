package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxe implements zzdti<zzcva<? extends zzcuz<JSONObject>>> {
    private static final zzcxe a = new zzcxe();

    public static zzcva<? extends zzcuz<JSONObject>> a() {
        return (zzcva) zzdto.b(tp.a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a();
    }
}
