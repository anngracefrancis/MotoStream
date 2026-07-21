package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblg implements zzdti<zzbah> {
    private final zzdtu<String> a;

    private zzblg(zzdtu<String> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzblg a(zzdtu<String> zzdtuVar) {
        return new zzblg(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbah) zzdto.b(new zzbah(this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
