package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblt implements zzbls {
    private zzaxb a;

    public zzblt(zzaxb zzaxbVar) {
        this.a = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void a(Map<String, String> map) {
        this.a.r(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
