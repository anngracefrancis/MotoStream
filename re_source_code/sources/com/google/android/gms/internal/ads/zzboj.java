package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboj implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f14616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzckm> f14617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcoc> f14618d;

    public zzboj(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzckm> zzdtuVar3, zzdtu<zzcoc> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14616b = zzdtuVar2;
        this.f14617c = zzdtuVar3;
        this.f14618d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.b(new zzcoe(this.a.get(), this.f14616b.get(), this.f14618d.get(), this.f14617c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
