package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjl implements zzdti<zzcjk> {
    private final zzdtu<zzcji> a;

    private zzcjl(zzdtu<zzcji> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcjl a(zzdtu<zzcji> zzdtuVar) {
        return new zzcjl(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjk(this.a.get());
    }
}
