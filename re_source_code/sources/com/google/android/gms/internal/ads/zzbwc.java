package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwc implements zzdti<View> {
    private final zzbvz a;

    private zzbwc(zzbvz zzbvzVar) {
        this.a = zzbvzVar;
    }

    public static zzbwc a(zzbvz zzbvzVar) {
        return new zzbwc(zzbvzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.a.d();
    }
}
