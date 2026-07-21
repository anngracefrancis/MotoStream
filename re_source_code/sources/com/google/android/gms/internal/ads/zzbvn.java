package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvn implements zzdti<zzbvj> {
    private final zzdtu<Set<zzbuz<zzahy>>> a;

    public zzbvn(zzdtu<Set<zzbuz<zzahy>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvj(this.a.get());
    }
}
