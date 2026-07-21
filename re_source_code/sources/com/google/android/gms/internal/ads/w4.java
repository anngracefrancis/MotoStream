package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class w4 extends zzawv {
    private final /* synthetic */ zzawm a;

    w4(zzawm zzawmVar) {
        this.a = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        zzacx zzacxVar = new zzacx(this.a.f14221f, this.a.f14222g.f14326f);
        synchronized (this.a.a) {
            try {
                zzk.zzlp();
                zzada.a(this.a.f14223h, zzacxVar);
            } catch (IllegalArgumentException e2) {
                zzbad.d("Cannot config CSI reporter.", e2);
            }
        }
    }
}
