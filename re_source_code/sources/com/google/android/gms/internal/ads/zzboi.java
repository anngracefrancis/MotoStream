package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboi implements zzdti<String> {
    private static final zzboi a = new zzboi();

    public static zzboi a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b("banner", "Cannot return null from a non-@Nullable @Provides method");
    }
}
