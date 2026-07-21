package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmc implements zzdti<zzbmb> {
    private final zzdtu<zzaxb> a;

    private zzbmc(zzdtu<zzaxb> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbmc a(zzdtu<zzaxb> zzdtuVar) {
        return new zzbmc(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbmb(this.a.get());
    }
}
