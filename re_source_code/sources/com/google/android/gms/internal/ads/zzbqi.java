package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqi implements zzdti<zzbuz<zzbrl>> {
    private final zzdtu<zzbme> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14687b;

    private zzbqi(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14687b = zzdtuVar2;
    }

    public static zzbqi a(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqi(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f14687b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
