package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwg implements zzdti<zzbuz<zzbsr>> {
    private final zzbvz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxa> f14772b;

    private zzbwg(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        this.a = zzbvzVar;
        this.f14772b = zzdtuVar;
    }

    public static zzbwg a(zzbvz zzbvzVar, zzdtu<zzbxa> zzdtuVar) {
        return new zzbwg(zzbvzVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14772b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
