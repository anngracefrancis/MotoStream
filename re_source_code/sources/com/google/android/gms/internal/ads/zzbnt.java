package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnt implements zzdti<Set<zzbuz<zzbsr>>> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbov> f14599b;

    public zzbnt(zzbnk zzbnkVar, zzdtu<zzbov> zzdtuVar) {
        this.a = zzbnkVar;
        this.f14599b = zzdtuVar;
    }

    public static Set<zzbuz<zzbsr>> a(zzbnk zzbnkVar, zzbov zzbovVar) {
        return (Set) zzdto.b(Collections.singleton(new zzbuz(zzbovVar, zzbbm.f14331b)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a, this.f14599b.get());
    }
}
