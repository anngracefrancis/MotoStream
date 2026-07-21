package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblq implements zzbal<zzcxu, zzcxu> {
    private Map<String, zzbls> a;

    public zzblq(Map<String, zzbls> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<zzcxu> zzf(zzcxu zzcxuVar) throws Exception {
        zzcxu zzcxuVar2 = zzcxuVar;
        for (zzcxt zzcxtVar : zzcxuVar2.f15747b.f15745c) {
            if (this.a.containsKey(zzcxtVar.a)) {
                this.a.get(zzcxtVar.a).a(zzcxtVar.f15746b);
            }
        }
        return zzbar.o(zzcxuVar2);
    }
}
