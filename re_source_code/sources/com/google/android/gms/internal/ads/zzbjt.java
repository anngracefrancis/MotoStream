package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjt implements zzdti<zzcjz<zzams, zzclb>> {
    private final zzbjn a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzclc> f14494b;

    public zzbjt(zzbjn zzbjnVar, zzdtu<zzclc> zzdtuVar) {
        this.a = zzbjnVar;
        this.f14494b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjz) zzdto.b(new zzcnk(this.f14494b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
