package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctf implements zzdti<zzctd> {
    private final zzdtu<zzbbl> a;

    private zzctf(zzdtu<zzbbl> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzctf a(zzdtu<zzbbl> zzdtuVar) {
        return new zzctf(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctd(this.a.get());
    }
}
