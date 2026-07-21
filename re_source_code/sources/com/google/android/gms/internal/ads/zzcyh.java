package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyh implements zzdti<zzbuz<zzbro>> {
    private final zzcyg a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcyi> f15770b;

    private zzcyh(zzcyg zzcygVar, zzdtu<zzcyi> zzdtuVar) {
        this.a = zzcygVar;
        this.f15770b = zzdtuVar;
    }

    public static zzcyh a(zzcyg zzcygVar, zzdtu<zzcyi> zzdtuVar) {
        return new zzcyh(zzcygVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f15770b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
