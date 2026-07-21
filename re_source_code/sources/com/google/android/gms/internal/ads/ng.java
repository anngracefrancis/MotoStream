package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ng implements zzbam {
    static final zzbam a = new ng();

    private ng() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadw zzadwVar : (List) obj) {
            if (zzadwVar != null) {
                arrayList.add(zzadwVar);
            }
        }
        return arrayList;
    }
}
