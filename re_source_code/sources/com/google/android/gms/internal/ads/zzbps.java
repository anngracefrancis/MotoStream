package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbps implements zzdti<zzcxm> {
    private final zzbpr a;

    private zzbps(zzbpr zzbprVar) {
        this.a = zzbprVar;
    }

    public static zzbps a(zzbpr zzbprVar) {
        return new zzbps(zzbprVar);
    }

    public static zzcxm b(zzbpr zzbprVar) {
        return (zzcxm) zzdto.b(zzbprVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
