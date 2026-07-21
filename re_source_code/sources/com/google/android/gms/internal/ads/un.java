package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class un implements zzbam {
    static final zzbam a = new un();

    private un() {
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final Object a(Object obj) {
        final ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcuz(arrayList) { // from class: com.google.android.gms.internal.ads.vn
            private final ArrayList a;

            {
                this.a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.a);
            }
        };
    }
}
