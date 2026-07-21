package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjz implements zzdti<zzasl> {
    private final zzdtu<Context> a;

    public zzbjz(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.a.get();
        return (zzasl) zzdto.b(new zzasj(context, new zzaso(context).a()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
