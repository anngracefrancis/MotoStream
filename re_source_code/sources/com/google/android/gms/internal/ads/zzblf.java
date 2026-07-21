package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblf implements zzdti<zzayu> {
    private final zzdtu<Context> a;

    public zzblf(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzayu) zzdto.b(new zzayu(this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
