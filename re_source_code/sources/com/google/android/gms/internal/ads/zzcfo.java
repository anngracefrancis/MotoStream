package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfo implements zzdti<zzcfn> {
    private final zzdtu<Clock> a;

    public zzcfo(zzdtu<Clock> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfn(this.a.get());
    }
}
