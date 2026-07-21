package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpf<AdT> implements zzbpe<AdT> {
    private final Map<String, zzcjv<AdT>> a;

    zzbpf(Map<String, zzcjv<AdT>> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final zzcjv<AdT> a(int i2, String str) {
        return this.a.get(str);
    }
}
