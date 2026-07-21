package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbud implements zzdti<Set<zzbuz<zzbro>>> {
    private final zzbtv a;

    private zzbud(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbud a(zzbtv zzbtvVar) {
        return new zzbud(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
