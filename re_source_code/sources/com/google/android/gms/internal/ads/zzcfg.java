package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfg implements zzdti<zzbuz<zzczz>> {
    private final zzdtu<zzcfk> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15165b;

    private zzcfg(zzdtu<zzcfk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15165b = zzdtuVar2;
    }

    public static zzcfg a(zzdtu<zzcfk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15165b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
