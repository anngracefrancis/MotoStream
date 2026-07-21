package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyw implements zzdti<zzbbl> {
    private static final zzcyw a = new zzcyw();

    public static zzcyw a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbl) zzdto.b(zzbbm.a(Executors.newSingleThreadExecutor()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
