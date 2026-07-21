package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbtz implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzbtv a;

    private zzbtz(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbtz a(zzbtv zzbtvVar) {
        return new zzbtz(zzbtvVar);
    }

    public static Set<zzbuz<zzbsr>> b(zzbtv zzbtvVar) {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
