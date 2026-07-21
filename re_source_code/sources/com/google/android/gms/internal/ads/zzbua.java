package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbua implements zzdti<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> {
    private final zzbtv a;

    private zzbua(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbua a(zzbtv zzbtvVar) {
        return new zzbua(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
