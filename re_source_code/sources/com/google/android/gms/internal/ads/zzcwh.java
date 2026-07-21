package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwh implements zzdti<mp> {
    private final zzdtu<Context> a;

    public zzcwh(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new mp(this.a.get());
    }
}
