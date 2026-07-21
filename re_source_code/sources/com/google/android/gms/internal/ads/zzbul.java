package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbul implements zzdti<Set<zzbuz<zzue>>> {
    private final zzbtv a;

    private zzbul(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbul a(zzbtv zzbtvVar) {
        return new zzbul(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
