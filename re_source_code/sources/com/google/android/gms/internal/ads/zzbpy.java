package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpy implements zzdti<zzbuz<zzxr>> {
    private final zzbpx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqe> f14675b;

    private zzbpy(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.a = zzbpxVar;
        this.f14675b = zzdtuVar;
    }

    public static zzbpy a(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbpy(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14675b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
