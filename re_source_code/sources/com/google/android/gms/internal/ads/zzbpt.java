package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpt implements zzdti<String> {
    private final zzbpr a;

    private zzbpt(zzbpr zzbprVar) {
        this.a = zzbprVar;
    }

    public static zzbpt a(zzbpr zzbprVar) {
        return new zzbpt(zzbprVar);
    }

    public static String b(zzbpr zzbprVar) {
        return (String) zzdto.b(zzbprVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
