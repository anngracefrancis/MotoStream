package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpw implements zzdti<zzbpv> {
    private final zzdtu<zzbse> a;

    private zzbpw(zzdtu<zzbse> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbpw a(zzdtu<zzbse> zzdtuVar) {
        return new zzbpw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpv(this.a.get());
    }
}
