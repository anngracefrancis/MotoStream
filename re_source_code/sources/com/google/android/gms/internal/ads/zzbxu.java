package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxu implements zzdti<String> {
    private static final zzbxu a = new zzbxu();

    public static zzbxu a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b("native", "Cannot return null from a non-@Nullable @Provides method");
    }
}
