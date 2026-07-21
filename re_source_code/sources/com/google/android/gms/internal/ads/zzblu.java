package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblu implements zzdti<zzblt> {
    private final zzdtu<zzaxb> a;

    private zzblu(zzdtu<zzaxb> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzblu a(zzdtu<zzaxb> zzdtuVar) {
        return new zzblu(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblt(this.a.get());
    }
}
