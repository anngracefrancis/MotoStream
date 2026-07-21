package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzceh implements zzdti<zzbuz<zzbro>> {
    private final zzdtu<zzcep> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15142b;

    private zzceh(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15142b = zzdtuVar2;
    }

    public static zzceh a(zzdtu<zzcep> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzceh(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15142b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
