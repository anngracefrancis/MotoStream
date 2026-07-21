package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfr implements zzdti<Set<zzbuz<zzbro>>> {
    private final zzcfp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcfz> f15175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15176c;

    private zzcfr(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzcfpVar;
        this.f15175b = zzdtuVar;
        this.f15176c = zzdtuVar2;
    }

    public static zzcfr a(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfr(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(zzcfp.e(this.f15175b.get(), this.f15176c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
