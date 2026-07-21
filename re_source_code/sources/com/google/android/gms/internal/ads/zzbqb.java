package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqb implements zzdti<zzbuz<zzbsr>> {
    private final zzbpx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqe> f14678b;

    private zzbqb(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        this.a = zzbpxVar;
        this.f14678b = zzdtuVar;
    }

    public static zzbqb a(zzbpx zzbpxVar, zzdtu<zzbqe> zzdtuVar) {
        return new zzbqb(zzbpxVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbuz) zzdto.b(new zzbuz(this.f14678b.get(), zzbbm.f14331b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
