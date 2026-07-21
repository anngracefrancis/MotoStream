package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqc implements zzdti<zzbuz<zzbtk>> {
    private final zzbpx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqe> f14679b;

    private zzbqc(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.a = zzbpxVar;
        this.f14679b = zzdtuVar;
    }

    public static zzbqc a(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqc(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14679b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
