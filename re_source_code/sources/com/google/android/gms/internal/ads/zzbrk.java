package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrk implements zzdti<zzbri> {
    private final zzdtu<Set<zzbuz<zzxr>>> a;

    private zzbrk(zzdtu<Set<zzbuz<zzxr>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbrk a(zzdtu<Set<zzbuz<zzxr>>> zzdtuVar) {
        return new zzbrk(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbri(this.a.get());
    }
}
