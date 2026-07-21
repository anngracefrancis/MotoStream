package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzche implements zzdti<ApplicationInfo> {
    private final zzdtu<Context> a;

    private zzche(zzdtu<Context> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzche a(zzdtu<Context> zzdtuVar) {
        return new zzche(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ApplicationInfo) zzdto.b(this.a.get().getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
