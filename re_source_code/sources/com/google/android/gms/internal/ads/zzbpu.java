package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpu implements zzdti<zzcxu> {
    private final zzbpr a;

    private zzbpu(zzbpr zzbprVar) {
        this.a = zzbprVar;
    }

    public static zzbpu a(zzbpr zzbprVar) {
        return new zzbpu(zzbprVar);
    }

    public static zzcxu b(zzbpr zzbprVar) {
        return (zzcxu) zzdto.b(zzbprVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
