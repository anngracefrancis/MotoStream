package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcib implements zzdti<zzchz> {
    private final zzdtu<Context> a;

    public zzcib(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzchz(this.a.get());
    }
}
