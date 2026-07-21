package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcso implements zzdti<zzcxk> {
    private final zzdtu<Clock> a;

    public zzcso(zzdtu<Clock> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcxk) zzdto.b(new zzcxk(this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
