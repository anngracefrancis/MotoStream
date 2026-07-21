package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyk implements zzdti<zzbuz<zzbrw>> {
    private final zzbyc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcac> f14851b;

    public zzbyk(zzbyc zzbycVar, zzdtu<zzcac> zzdtuVar) {
        this.a = zzbycVar;
        this.f14851b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14851b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
