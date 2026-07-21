package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsl implements zzdti<zzbse> {
    private final zzdtu<Set<zzbuz<zzbrl>>> a;

    private zzbsl(zzdtu<Set<zzbuz<zzbrl>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbsl a(zzdtu<Set<zzbuz<zzbrl>>> zzdtuVar) {
        return new zzbsl(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbse(this.a.get());
    }
}
