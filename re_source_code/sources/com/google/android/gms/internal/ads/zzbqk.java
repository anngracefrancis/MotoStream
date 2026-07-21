package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqk implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<zzbme> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f14689b;

    private zzbqk(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14689b = zzdtuVar2;
    }

    public static zzbuz<zzbsr> a(zzbme zzbmeVar, Executor executor) {
        return (zzbuz) zzdto.b(new zzbuz(zzbmeVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbqk b(zzdtu<zzbme> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbqk(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a.get(), this.f14689b.get());
    }
}
