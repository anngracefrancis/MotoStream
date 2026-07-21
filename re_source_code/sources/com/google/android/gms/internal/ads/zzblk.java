package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblk implements zzdti<zzawf> {
    private static final zzblk a = new zzblk();

    public static zzblk a() {
        return a;
    }

    public static zzawf b() {
        return (zzawf) zzdto.b(new zzawf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
