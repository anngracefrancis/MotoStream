package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfq implements zzdti<Set<zzbuz<zzbrl>>> {
    private final zzcfp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcfz> f15173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15174c;

    private zzcfq(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzcfpVar;
        this.f15173b = zzdtuVar;
        this.f15174c = zzdtuVar2;
    }

    public static zzcfq a(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfq(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(zzcfp.f(this.f15173b.get(), this.f15174c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
