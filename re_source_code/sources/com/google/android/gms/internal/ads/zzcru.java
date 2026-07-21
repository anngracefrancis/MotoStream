package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcru implements zzdti<sn> {
    private final zzdtu<Set<String>> a;

    private zzcru(zzdtu<Set<String>> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcru a(zzdtu<Set<String>> zzdtuVar) {
        return new zzcru(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new sn(this.a.get());
    }
}
