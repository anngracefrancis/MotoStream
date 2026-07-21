package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbgf extends zzbft {
    public zzbgf(zzbdf zzbdfVar) {
        super(zzbdfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        zzbdf zzbdfVar = this.f14432h.get();
        if (zzbdfVar != null) {
            zzbdfVar.g(z(str), this);
        }
        zzbad.i("VideoStreamNoopCache is doing nothing.");
        q(str, z(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
