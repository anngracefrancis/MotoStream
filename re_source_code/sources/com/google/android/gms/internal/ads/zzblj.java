package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblj implements zzdti<zzwa> {
    private static final zzblj a = new zzblj();

    public static zzblj a() {
        return a;
    }

    public static zzwa b() {
        return (zzwa) zzdto.b(new zzwa(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
