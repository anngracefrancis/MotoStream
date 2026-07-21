package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrf implements zzdti<zzbqy.zza> {
    private final zzbqy a;

    private zzbrf(zzbqy zzbqyVar) {
        this.a = zzbqyVar;
    }

    public static zzbrf a(zzbqy zzbqyVar) {
        return new zzbrf(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbqy.zza) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
