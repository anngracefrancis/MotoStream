package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmu implements zzdti<zzaly> {
    private final zzdtu<zzalr> a;

    private zzbmu(zzdtu<zzalr> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzbmu a(zzdtu<zzalr> zzdtuVar) {
        return new zzbmu(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzaly) zzdto.b(this.a.get().b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
