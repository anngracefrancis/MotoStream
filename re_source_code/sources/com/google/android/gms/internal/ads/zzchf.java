package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchf implements zzdti<List<String>> {
    private static final zzchf a = new zzchf();

    public static zzchf a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (List) zzdto.b(zzacu.c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
