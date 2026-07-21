package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyv implements zzdti<Executor> {
    private static final zzcyv a = new zzcyv();

    public static zzcyv a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Executor) zzdto.b(zzbbm.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
