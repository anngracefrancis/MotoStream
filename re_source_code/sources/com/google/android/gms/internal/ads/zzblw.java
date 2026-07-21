package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblw implements zzdti<zzblv> {
    private final zzdtu<zzaxb> a;

    private zzblw(zzdtu<zzaxb> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzblw a(zzdtu<zzaxb> zzdtuVar) {
        return new zzblw(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblv(this.a.get());
    }
}
