package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjs implements zzdti<zzcjz<zzams, zzcla>> {
    private final zzbjn a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzclc> f14493b;

    public zzbjs(zzbjn zzbjnVar, zzdtu<zzclc> zzdtuVar) {
        this.a = zzbjnVar;
        this.f14493b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjz) zzdto.b(new zzclv(this.f14493b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
