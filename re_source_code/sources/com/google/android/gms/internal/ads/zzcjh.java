package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjh implements zzdti<zzcjg> {
    private final zzdtu<zzcjm> a;

    private zzcjh(zzdtu<zzcjm> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcjh a(zzdtu<zzcjm> zzdtuVar) {
        return new zzcjh(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjg(this.a.get());
    }
}
