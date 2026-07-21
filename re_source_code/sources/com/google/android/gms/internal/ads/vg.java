package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class vg implements zzbam {
    static final zzbam a = new vg();

    private vg() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcbg zzcbgVar : (List) obj) {
            if (zzcbgVar != null) {
                arrayList.add(zzcbgVar);
            }
        }
        return arrayList;
    }
}
