package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzciy implements zzdti<zzbuz<zzbsr>> {
    private final zzdtu<zzcjg> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15284b;

    private zzciy(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15284b = zzdtuVar2;
    }

    public static zzciy a(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzciy(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15284b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
