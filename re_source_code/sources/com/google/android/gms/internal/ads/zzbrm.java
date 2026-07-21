package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrm extends zzbts<zzbro> implements zzbro {
    public zzbrm(Set<zzbuz<zzbro>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(final int i2) {
        T(new zzbtu(i2) { // from class: com.google.android.gms.internal.ads.rd
            private final int a;

            {
                this.a = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbro) obj).onAdFailedToLoad(this.a);
            }
        });
    }
}
