package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsq implements zzdti<zzbso> {
    private final zzdtu<Set<zzbuz<zzbsr>>> a;

    private zzbsq(zzdtu<Set<zzbuz<zzbsr>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbsq a(zzdtu<Set<zzbuz<zzbsr>>> zzdtuVar) {
        return new zzbsq(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbso(this.a.get());
    }
}
