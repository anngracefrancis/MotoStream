package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyf implements zzdti<zzbyx> {
    private final zzbyc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyy> f14847b;

    public zzbyf(zzbyc zzbycVar, zzdtu<zzbyy> zzdtuVar) {
        this.a = zzbycVar;
        this.f14847b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbyx) zzdto.b(this.f14847b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
