package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwx implements zzdti<String> {
    private static final zzbwx a = new zzbwx();

    public static zzbwx a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b("interstitial", "Cannot return null from a non-@Nullable @Provides method");
    }
}
