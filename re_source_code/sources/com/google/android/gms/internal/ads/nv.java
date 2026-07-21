package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class nv extends kv {
    private nv() {
        super();
    }

    private static <E> zzdoj<E> f(Object obj, long j2) {
        return (zzdoj) gx.L(obj, j2);
    }

    @Override // com.google.android.gms.internal.ads.kv
    final <L> List<L> a(Object obj, long j2) {
        zzdoj zzdojVarF = f(obj, j2);
        if (zzdojVarF.m0()) {
            return zzdojVarF;
        }
        int size = zzdojVarF.size();
        zzdoj zzdojVarN = zzdojVarF.N(size == 0 ? 10 : size << 1);
        gx.g(obj, j2, zzdojVarN);
        return zzdojVarN;
    }

    @Override // com.google.android.gms.internal.ads.kv
    final <E> void b(Object obj, Object obj2, long j2) {
        zzdoj zzdojVarF = f(obj, j2);
        zzdoj zzdojVarF2 = f(obj2, j2);
        int size = zzdojVarF.size();
        int size2 = zzdojVarF2.size();
        if (size > 0 && size2 > 0) {
            if (!zzdojVarF.m0()) {
                zzdojVarF = zzdojVarF.N(size2 + size);
            }
            zzdojVarF.addAll(zzdojVarF2);
        }
        if (size > 0) {
            zzdojVarF2 = zzdojVarF;
        }
        gx.g(obj, j2, zzdojVarF2);
    }

    @Override // com.google.android.gms.internal.ads.kv
    final void e(Object obj, long j2) {
        f(obj, j2).x0();
    }
}
