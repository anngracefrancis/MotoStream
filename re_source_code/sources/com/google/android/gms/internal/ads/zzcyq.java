package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyq implements zzdti<zzcym> {
    private final zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcyk> f15785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<String> f15786c;

    private zzcyq(zzcyo zzcyoVar, zzdtu<zzcyk> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.a = zzcyoVar;
        this.f15785b = zzdtuVar;
        this.f15786c = zzdtuVar2;
    }

    public static zzcyq a(zzcyo zzcyoVar, zzdtu<zzcyk> zzdtuVar, zzdtu<String> zzdtuVar2) {
        return new zzcyq(zzcyoVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcym) zzdto.b(this.f15785b.get().b(this.f15786c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
