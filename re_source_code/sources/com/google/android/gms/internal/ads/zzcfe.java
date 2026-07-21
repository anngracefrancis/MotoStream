package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfe implements zzdti<zzbuz<zzbro>> {
    private final zzdtu<zzcfb> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15163b;

    private zzcfe(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15163b = zzdtuVar2;
    }

    public static zzcfe a(zzdtu<zzcfb> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfe(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15163b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
