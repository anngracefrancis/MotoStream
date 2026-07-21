package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbuk implements zzdti<zzbtv> {
    private final zzbtv a;

    private zzbuk(zzbtv zzbtvVar) {
        this.a = zzbtvVar;
    }

    public static zzbuk a(zzbtv zzbtvVar) {
        return new zzbuk(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbtv zzbtvVar = this.a;
        zzbtvVar.getClass();
        return (zzbtv) zzdto.b(zzbtvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
