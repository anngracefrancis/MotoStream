package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsd implements zzdti<zzbry> {
    private final zzdtu<Set<zzbuz<zzbrx>>> a;

    private zzbsd(zzdtu<Set<zzbuz<zzbrx>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbsd a(zzdtu<Set<zzbuz<zzbrx>>> zzdtuVar) {
        return new zzbsd(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbry(this.a.get());
    }
}
