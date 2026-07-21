package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxf implements zzdti<zzbxe> {
    private final zzdtu<zzbry> a;

    private zzbxf(zzdtu<zzbry> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbxf a(zzdtu<zzbry> zzdtuVar) {
        return new zzbxf(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxe(this.a.get());
    }
}
