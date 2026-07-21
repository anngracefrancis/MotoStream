package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchh implements zzdti<String> {
    private final zzdtu<Context> a;

    private zzchh(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzchh a(zzdtu<Context> zzdtuVar) {
        return new zzchh(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b(this.a.get().getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
