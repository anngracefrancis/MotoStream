package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class l0 implements zzaho<zzbgz> {
    l0() {
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        if (map.keySet().contains("start")) {
            zzbgzVar2.S(true);
        }
        if (map.keySet().contains("stop")) {
            zzbgzVar2.S(false);
        }
    }
}
