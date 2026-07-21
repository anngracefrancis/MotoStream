package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzciz implements zzdti<zzbuz<zzczz>> {
    private final zzdtu<zzcjk> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15285b;

    private zzciz(zzdtu<zzcjk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15285b = zzdtuVar2;
    }

    public static zzciz a(zzdtu<zzcjk> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzciz(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15285b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
