package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbln implements zzdti<zzawi> {
    private static final zzbln a = new zzbln();

    public static zzbln a() {
        return a;
    }

    public static zzawi b() {
        return (zzawi) zzdto.b(new zzawg(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b();
    }
}
