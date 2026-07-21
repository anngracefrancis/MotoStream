package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctj implements zzdti<zzcth> {
    private final zzdtu<zzbbl> a;

    private zzctj(zzdtu<zzbbl> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzctj a(zzdtu<zzbbl> zzdtuVar) {
        return new zzctj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcth(this.a.get());
    }
}
