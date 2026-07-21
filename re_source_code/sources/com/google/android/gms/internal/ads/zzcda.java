package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcda implements zzdti<zzccz> {
    private final zzdtu<zzbse> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxm> f15086b;

    public zzcda(zzdtu<zzbse> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15086b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccz(this.a.get(), this.f15086b.get());
    }
}
