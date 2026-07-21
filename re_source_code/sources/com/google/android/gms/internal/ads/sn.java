package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class sn implements zzcva<zzcuz<Bundle>> {
    private final Set<String> a;

    sn(Set<String> set) {
        this.a = set;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> b() {
        final ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return zzbar.o(new zzcuz(arrayList) { // from class: com.google.android.gms.internal.ads.tn
            private final ArrayList a;

            {
                this.a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.a);
            }
        });
    }
}
