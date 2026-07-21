package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwl implements zzdti<zzbuz<zzbrl>> {
    private final zzbvz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxg> f14777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14778c;

    private zzbwl(zzbvz zzbvzVar, zzdtu<zzbxg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzbvzVar;
        this.f14777b = zzdtuVar;
        this.f14778c = zzdtuVar2;
    }

    public static zzbwl a(zzbvz zzbvzVar, zzdtu<zzbxg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzbwl(zzbvzVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14777b.get(), this.f14778c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
