package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqa implements zzdti<zzbuz<zzbrw>> {
    private final zzbpx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqe> f14677b;

    private zzbqa(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.a = zzbpxVar;
        this.f14677b = zzdtuVar;
    }

    public static zzbqa a(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqa(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14677b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
