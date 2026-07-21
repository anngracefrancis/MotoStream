package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbue implements zzdti<Set<zzbuz<zzbrs>>> {
    private final zzbtv a;

    public zzbue(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.e(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
