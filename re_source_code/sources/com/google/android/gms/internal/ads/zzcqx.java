package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqx implements zzdti<Set<String>> {
    private final zzcqt a;

    public zzcqx(zzcqt zzcqtVar) {
        this.a = zzcqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
