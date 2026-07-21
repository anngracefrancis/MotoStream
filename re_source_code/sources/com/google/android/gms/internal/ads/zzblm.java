package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblm implements zzdti<zzaql> {
    private static final zzblm a = new zzblm();

    public static zzblm a() {
        return a;
    }

    public static zzaql b() {
        return (zzaql) zzdto.b(new zzaql(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
