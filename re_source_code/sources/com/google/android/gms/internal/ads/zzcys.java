package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcys implements zzdti<zzdh> {
    private final zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcym> f15788b;

    private zzcys(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.a = zzcyoVar;
        this.f15788b = zzdtuVar;
    }

    public static zzcys a(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcys(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzdh) zzdto.b(this.f15788b.get().f15781d, "Cannot return null from a non-@Nullable @Provides method");
    }
}
