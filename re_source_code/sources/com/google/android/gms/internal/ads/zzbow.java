package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbow implements zzdti<zzbov> {
    private final zzdtu<zzcxm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbrt> f14642b;

    public zzbow(zzdtu<zzcxm> zzdtuVar, zzdtu<zzbrt> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14642b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbov(this.a.get(), this.f14642b.get());
    }
}
