package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyt implements zzdti<zzawu> {
    private final zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcym> f15789b;

    private zzcyt(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.a = zzcyoVar;
        this.f15789b = zzdtuVar;
    }

    public static zzcyt a(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyt(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzawu) zzdto.b(this.f15789b.get().f15780c, "Cannot return null from a non-@Nullable @Provides method");
    }
}
