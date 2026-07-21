package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrr implements zzdti<zzbrp> {
    private final zzdtu<Set<zzbuz<zzbrs>>> a;

    public zzbrr(zzdtu<Set<zzbuz<zzbrs>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbrp(this.a.get());
    }
}
