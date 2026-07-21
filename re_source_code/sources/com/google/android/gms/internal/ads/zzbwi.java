package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwi implements zzdti<zzbuz<zzahy>> {
    private final zzbvz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzccz> f14774b;

    public zzbwi(zzbvz zzbvzVar, zzdtu<zzccz> zzdtuVar) {
        this.a = zzbvzVar;
        this.f14774b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14774b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
