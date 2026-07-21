package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdab implements zzdti<lq> {
    private final zzdtu<Set<zzbuz<zzczz>>> a;

    private zzdab(zzdtu<Set<zzbuz<zzczz>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzdab a(zzdtu<Set<zzbuz<zzczz>>> zzdtuVar) {
        return new zzdab(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new lq(this.a.get());
    }
}
