package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbre implements zzdti<zzcxv> {
    private final zzbqy a;

    private zzbre(zzbqy zzbqyVar) {
        this.a = zzbqyVar;
    }

    public static zzbre a(zzbqy zzbqyVar) {
        return new zzbre(zzbqyVar);
    }

    public static zzcxv b(zzbqy zzbqyVar) {
        return (zzcxv) zzdto.b(zzbqyVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
