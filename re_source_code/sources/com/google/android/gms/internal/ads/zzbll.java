package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbll implements zzdti<zzamh> {
    private static final zzbll a = new zzbll();

    public static zzbll a() {
        return a;
    }

    public static zzamh b() {
        return (zzamh) zzdto.b(new zzamh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
