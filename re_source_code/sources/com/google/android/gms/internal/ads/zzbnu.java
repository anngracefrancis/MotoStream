package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnu implements zzdti<zzbuz<zzbrw>> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbot> f14600b;

    public zzbnu(zzbnk zzbnkVar, zzdtu<zzbot> zzdtuVar) {
        this.a = zzbnkVar;
        this.f14600b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14600b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
