package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class y8 implements zzgh {
    private final /* synthetic */ zzbdq a;

    y8(zzbdq zzbdqVar) {
        this.a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void a(boolean z, int i2) {
        if (this.a.w != i2) {
            this.a.w = i2;
            if (i2 == 4) {
                this.a.R();
            } else {
                if (i2 != 5) {
                    return;
                }
                this.a.N();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void b(zzgd zzgdVar) {
        this.a.L("PlayerError", zzgdVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void c() {
    }
}
