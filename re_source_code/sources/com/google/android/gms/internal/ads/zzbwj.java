package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwj implements zzdti<zzavf> {
    private final zzbvz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14776c;

    private zzbwj(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.a = zzbvzVar;
        this.f14775b = zzdtuVar;
        this.f14776c = zzdtuVar2;
    }

    public static zzbwj a(zzbvz zzbvzVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzbwj(zzbvzVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.b(new zzavf(this.f14775b.get(), this.f14776c.get().f15752f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
