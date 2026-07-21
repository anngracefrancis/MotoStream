package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchi implements zzdti<zzchv> {
    private final zzdtu<Context> a;

    private zzchi(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzchi a(zzdtu<Context> zzdtuVar) {
        return new zzchi(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzchv) zzdto.b(new zzchv(this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
