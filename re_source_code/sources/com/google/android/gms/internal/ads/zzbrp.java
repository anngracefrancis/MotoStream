package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrp extends zzbts<zzbrs> implements zzbrs {
    public zzbrp(Set<zzbuz<zzbrs>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final void R(final int i2) {
        T(new zzbtu(i2) { // from class: com.google.android.gms.internal.ads.sd
            private final int a;

            {
                this.a = i2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzbrs) obj).R(this.a);
            }
        });
    }
}
