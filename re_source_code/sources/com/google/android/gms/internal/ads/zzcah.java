package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcah implements zzdti<zzbzb> {
    private final zzcag a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcae> f14980b;

    public zzcah(zzcag zzcagVar, zzdtu<zzcae> zzdtuVar) {
        this.a = zzcagVar;
        this.f14980b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbzb) zzdto.b(this.f14980b.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
