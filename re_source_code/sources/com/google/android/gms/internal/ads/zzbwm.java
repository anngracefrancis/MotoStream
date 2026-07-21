package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwm implements zzdti<Set<zzbuz<zzbuu>>> {
    private final zzdtu<zzbxe> a;

    private zzbwm(zzdtu<zzbxe> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbwm a(zzdtu<zzbxe> zzdtuVar) {
        return new zzbwm(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(Collections.singleton(zzbuz.a(this.a.get(), zzbbm.f14331b)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
