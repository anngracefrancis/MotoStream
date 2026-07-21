package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbli implements zzdti<zzach> {
    private static final zzbli a = new zzbli();

    public static zzach a() {
        return (zzach) zzdto.b(new zzach(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a();
    }
}
