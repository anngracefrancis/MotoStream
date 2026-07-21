package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqx implements zzdti<zzbtb> {
    private final zzdtu<zzbtb> a;

    private zzbqx(zzdtu<zzbtb> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbqx a(zzdtu<zzbtb> zzdtuVar) {
        return new zzbqx(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbtb) zzdto.b(this.a.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
