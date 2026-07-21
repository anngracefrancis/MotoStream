package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjb implements zzdti<zzcja> {
    private final zzdtu<Context> a;

    private zzcjb(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcjb a(zzdtu<Context> zzdtuVar) {
        return new zzcjb(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcja(this.a.get());
    }
}
