package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyp implements zzdti<zzaxb> {
    private final zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcym> f15784b;

    private zzcyp(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.a = zzcyoVar;
        this.f15784b = zzdtuVar;
    }

    public static zzcyp a(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyp(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzaxb) zzdto.b(this.f15784b.get().f15779b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
