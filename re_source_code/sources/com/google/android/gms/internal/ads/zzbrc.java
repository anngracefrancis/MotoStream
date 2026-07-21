package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrc implements zzdti<Bundle> {
    private final zzbqy a;

    private zzbrc(zzbqy zzbqyVar) {
        this.a = zzbqyVar;
    }

    public static zzbrc a(zzbqy zzbqyVar) {
        return new zzbrc(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.a.c();
    }
}
