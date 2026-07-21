package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbub implements zzdti<Set<zzbuz<zzbto>>> {
    private final zzbtv a;

    private zzbub(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbub a(zzbtv zzbtvVar) {
        return new zzbub(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
