package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyg implements zzdti<zzbzb> {
    private final zzbyc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxx> f14848b;

    public zzbyg(zzbyc zzbycVar, zzdtu<zzbxx> zzdtuVar) {
        this.a = zzbycVar;
        this.f14848b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbzb) zzdto.b(this.f14848b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
