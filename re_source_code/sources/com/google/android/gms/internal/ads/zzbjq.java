package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjq implements zzdti<Context> {
    private final zzbjn a;

    public zzbjq(zzbjn zzbjnVar) {
        this.a = zzbjnVar;
    }

    public static Context a(zzbjn zzbjnVar) {
        return (Context) zzdto.b(zzbjnVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
