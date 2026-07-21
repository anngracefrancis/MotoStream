package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfc implements zzdti<zzcfb> {
    private final zzdtu<zzcfi> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzdae> f15161b;

    private zzcfc(zzdtu<zzcfi> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15161b = zzdtuVar2;
    }

    public static zzcfc a(zzdtu<zzcfi> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        return new zzcfc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfb(this.a.get(), this.f15161b.get());
    }
}
