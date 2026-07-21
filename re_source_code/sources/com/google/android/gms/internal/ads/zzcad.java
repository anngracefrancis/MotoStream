package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcad implements zzdti<zzcac> {
    private final zzdtu<zzbyt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyx> f14959b;

    public zzcad(zzdtu<zzbyt> zzdtuVar, zzdtu<zzbyx> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14959b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcac(this.a.get(), this.f14959b.get());
    }
}
