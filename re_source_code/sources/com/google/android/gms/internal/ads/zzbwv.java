package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwv implements zzdti<zzbuz<zzbrl>> {
    private final zzdtu<zzbus> a;

    public zzbwv(zzdtu<zzbus> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.a.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
