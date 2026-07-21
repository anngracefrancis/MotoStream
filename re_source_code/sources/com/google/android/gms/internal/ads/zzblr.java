package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblr implements zzdti<zzblq> {
    private final zzdtu<Map<String, zzbls>> a;

    private zzblr(zzdtu<Map<String, zzbls>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzblr a(zzdtu<Map<String, zzbls>> zzdtuVar) {
        return new zzblr(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblq(this.a.get());
    }
}
