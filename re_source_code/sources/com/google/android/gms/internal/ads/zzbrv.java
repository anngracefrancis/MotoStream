package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrv implements zzdti<zzbrt> {
    private final zzdtu<Set<zzbuz<zzbrw>>> a;

    private zzbrv(zzdtu<Set<zzbuz<zzbrw>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbrv a(zzdtu<Set<zzbuz<zzbrw>>> zzdtuVar) {
        return new zzbrv(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbrt(this.a.get());
    }
}
