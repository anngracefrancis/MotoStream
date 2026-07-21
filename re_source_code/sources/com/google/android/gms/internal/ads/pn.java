package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class pn implements zzbal {
    static final zzbal a = new pn();

    private pn() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        final String str = (String) obj;
        return zzbar.o(new zzcuz(str) { // from class: com.google.android.gms.internal.ads.qn
            private final String a;

            {
                this.a = str;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Object obj2) {
                ((Bundle) obj2).putString("ms", this.a);
            }
        });
    }
}
