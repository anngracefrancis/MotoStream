package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyi implements zzdti<zzbva> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxm> f14849b;

    public zzbyi(zzdtu<Context> zzdtuVar, zzdtu<zzcxm> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14849b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbva) zzdto.b(new zzbva(this.a.get(), new HashSet(), this.f14849b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
