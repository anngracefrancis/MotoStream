package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbly implements zzdti<zzblx> {
    private final zzdtu<zzcxk> a;

    private zzbly(zzdtu<zzcxk> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbly a(zzdtu<zzcxk> zzdtuVar) {
        return new zzbly(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblx(this.a.get());
    }
}
