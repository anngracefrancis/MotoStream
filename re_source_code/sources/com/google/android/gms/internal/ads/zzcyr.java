package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyr implements zzdti<Context> {
    private final zzcyo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcym> f15787b;

    private zzcyr(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.a = zzcyoVar;
        this.f15787b = zzdtuVar;
    }

    public static zzcyr a(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyr(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.b(this.f15787b.get().a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
