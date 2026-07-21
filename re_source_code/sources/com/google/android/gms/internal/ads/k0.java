package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class k0 implements zzaho<zzbgz> {
    k0() {
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        if (map.keySet().contains("start")) {
            zzbgzVar2.p().f();
        } else if (map.keySet().contains("stop")) {
            zzbgzVar2.p().h();
        } else if (map.keySet().contains("cancel")) {
            zzbgzVar2.p().k();
        }
    }
}
