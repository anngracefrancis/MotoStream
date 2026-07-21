package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvj extends zzbts<zzahy> implements zzahy {
    public zzbvj(Set<zzbuz<zzahy>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void P(final zzato zzatoVar) {
        T(new zzbtu(zzatoVar) { // from class: com.google.android.gms.internal.ads.df
            private final zzato a;

            {
                this.a = zzatoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzahy) obj).P(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void j() {
        T(ef.a);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final synchronized void r() {
        T(cf.a);
    }
}
