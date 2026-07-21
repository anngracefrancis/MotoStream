package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbum implements zzdti<Set<zzbuz<zzbvg>>> {
    private final zzbtv a;

    private zzbum(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbum a(zzbtv zzbtvVar) {
        return new zzbum(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
