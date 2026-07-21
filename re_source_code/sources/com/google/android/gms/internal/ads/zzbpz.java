package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpz implements zzdti<zzbuz<zzbrl>> {
    private final zzbpx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqe> f14676b;

    private zzbpz(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.a = zzbpxVar;
        this.f14676b = zzdtuVar;
    }

    public static zzbpz a(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbpz(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14676b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
