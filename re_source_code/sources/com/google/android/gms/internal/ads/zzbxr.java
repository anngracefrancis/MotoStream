package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxr implements zzdti<Set<String>> {
    private final zzdtu<zzbzc> a;

    public zzbxr(zzdtu<zzbzc> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.get().d() != null ? Collections.singleton("banner") : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
