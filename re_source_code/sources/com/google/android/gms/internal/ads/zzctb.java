package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctb implements zzdti<zzcsz> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f15615b;

    private zzctb(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15615b = zzdtuVar2;
    }

    public static zzctb a(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzctb(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsz(this.a.get(), this.f15615b.get());
    }
}
