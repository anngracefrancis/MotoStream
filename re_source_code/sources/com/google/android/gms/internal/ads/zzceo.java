package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzceo implements zzdti<Set<zzbuz<zzczz>>> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcex> f15146b;

    private zzceo(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15146b = zzdtuVar2;
    }

    public static zzceo a(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        return new zzceo(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Executor executor = this.a.get();
        return (Set) zzdto.b(((Boolean) zzyt.e().c(zzacu.S3)).booleanValue() ? Collections.singleton(new zzbuz(this.f15146b.get(), executor)) : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
