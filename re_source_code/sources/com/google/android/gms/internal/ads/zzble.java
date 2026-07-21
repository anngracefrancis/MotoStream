package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzble implements zzdti<zzdan> {
    private final zzdtu<Context> a;

    public zzble(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzdan) zzdto.b(new zzdan(this.a.get(), zzk.zzlu().b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
