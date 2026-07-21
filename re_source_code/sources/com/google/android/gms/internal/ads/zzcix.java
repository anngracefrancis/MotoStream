package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcix implements zzdti<zzbuz<zzbro>> {
    private final zzdtu<zzcjg> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Executor> f15283b;

    private zzcix(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15283b = zzdtuVar2;
    }

    public static zzcix a(zzdtu<zzcjg> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcix(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), this.f15283b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
