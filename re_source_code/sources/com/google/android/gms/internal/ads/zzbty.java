package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbty implements zzdti<Set<zzbuz<zzbrx>>> {
    private final zzbtv a;

    private zzbty(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbty a(zzbtv zzbtvVar) {
        return new zzbty(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
