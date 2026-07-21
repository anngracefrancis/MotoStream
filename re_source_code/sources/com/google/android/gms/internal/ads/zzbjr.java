package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjr implements zzdti<Context> {
    private final zzbjn a;

    public zzbjr(zzbjn zzbjnVar) {
        this.a = zzbjnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Context) zzdto.b(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
