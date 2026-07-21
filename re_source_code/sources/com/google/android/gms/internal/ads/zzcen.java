package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcen implements zzdti<String> {
    private static final zzcen a = new zzcen();

    public static zzcen a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzk.zzlg();
        return (String) zzdto.b(zzaxi.j0(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
