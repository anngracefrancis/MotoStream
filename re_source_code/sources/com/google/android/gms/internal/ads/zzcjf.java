package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjf implements zzdti<zzcjc> {
    private final zzdtu<zzcja> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15287b;

    private zzcjf(zzdtu<zzcja> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15287b = zzdtuVar2;
    }

    public static zzcjf a(zzdtu<zzcja> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcjf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcjc(this.a.get(), this.f15287b.get());
    }
}
