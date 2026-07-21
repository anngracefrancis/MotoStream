package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpg<AdT> implements zzdti<zzbpf<AdT>> {
    private final zzdtu<Map<String, zzcjv<AdT>>> a;

    private zzbpg(zzdtu<Map<String, zzcjv<AdT>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static <AdT> zzbpg<AdT> a(zzdtu<Map<String, zzcjv<AdT>>> zzdtuVar) {
        return new zzbpg<>(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpf(this.a.get());
    }
}
