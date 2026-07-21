package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbtj implements zzdti<zzbtg> {
    private final zzdtu<Set<zzbuz<zzbtk>>> a;

    private zzbtj(zzdtu<Set<zzbuz<zzbtk>>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbtj a(zzdtu<Set<zzbuz<zzbtk>>> zzdtuVar) {
        return new zzbtj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbtg(this.a.get());
    }
}
