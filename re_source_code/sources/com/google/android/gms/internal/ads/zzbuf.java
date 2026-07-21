package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbuf implements zzdti<Set<zzbuz<zzbrw>>> {
    private final zzbtv a;

    private zzbuf(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbuf a(zzbtv zzbtvVar) {
        return new zzbuf(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.i(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
