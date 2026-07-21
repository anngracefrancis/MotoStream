package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbuy implements zzdti<zzbuv> {
    private final zzdtu<Set<zzbuz<zzbuu>>> a;

    private zzbuy(zzdtu<Set<zzbuz<zzbuu>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbuy a(zzdtu<Set<zzbuz<zzbuu>>> zzdtuVar) {
        return new zzbuy(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbuv(this.a.get());
    }
}
