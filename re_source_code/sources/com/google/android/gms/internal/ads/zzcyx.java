package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyx implements zzdti<zzbbl> {
    private static final zzcyx a = new zzcyx();

    public static zzcyx a() {
        return a;
    }

    public static zzbbl b() {
        return (zzbbl) zzdto.b(zzaxg.a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
