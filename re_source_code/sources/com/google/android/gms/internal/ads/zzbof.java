package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbof implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcmo> f14611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcoe<zzbnf, zzams, zzcla>> f14612c;

    public zzbof(zzdtu<Boolean> zzdtuVar, zzdtu<zzcmo> zzdtuVar2, zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14611b = zzdtuVar2;
        this.f14612c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        boolean zBooleanValue = this.a.get().booleanValue();
        zzcmo zzcmoVar = this.f14611b.get();
        zzcoe<zzbnf, zzams, zzcla> zzcoeVar = this.f14612c.get();
        if (!zBooleanValue) {
            zzcmoVar = zzcoeVar;
        }
        return (zzcjv) zzdto.b(zzcmoVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
