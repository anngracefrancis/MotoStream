package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqj implements zzdti<zzbuz<zzbrw>> {
    private final zzdtu<zzbme> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14688b;

    private zzbqj(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14688b = zzdtuVar2;
    }

    public static zzbqj a(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqj(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f14688b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
