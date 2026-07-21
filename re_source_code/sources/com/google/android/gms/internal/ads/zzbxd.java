package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxd implements zzdti<zzbxc> {
    private final zzdtu<zzbrt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxm> f14801b;

    private zzbxd(zzdtu<zzbrt> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14801b = zzdtuVar2;
    }

    public static zzbxd a(zzdtu<zzbrt> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        return new zzbxd(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxc(this.a.get(), this.f14801b.get());
    }
}
