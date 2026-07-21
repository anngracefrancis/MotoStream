package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfu implements zzdti<Set<zzbuz<zzbtk>>> {
    private final zzcfp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcfz> f15181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f15182c;

    private zzcfu(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzcfpVar;
        this.f15181b = zzdtuVar;
        this.f15182c = zzdtuVar2;
    }

    public static zzcfu a(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfu(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(zzcfp.j(this.f15181b.get(), this.f15182c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
