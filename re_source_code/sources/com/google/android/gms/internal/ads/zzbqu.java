package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqu implements zzdti<zzbuz<zzbtk>> {
    private final zzbqt a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqr> f14702b;

    private zzbqu(zzbqt zzbqtVar, zzdtu<zzbqr> zzdtuVar) {
        this.a = zzbqtVar;
        this.f14702b = zzdtuVar;
    }

    public static zzbqu a(zzbqt zzbqtVar, zzdtu<zzbqr> zzdtuVar) {
        return new zzbqu(zzbqtVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14702b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
