package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcni extends zzcoj {
    private zzbvj m;
    private zzbrp n;

    public zzcni(zzbri zzbriVar, zzbrt zzbrtVar, zzbse zzbseVar, zzbso zzbsoVar, zzbrp zzbrpVar, zzbtp zzbtpVar, zzbvq zzbvqVar, zzbsv zzbsvVar, zzbvj zzbvjVar) {
        super(zzbriVar, zzbrtVar, zzbseVar, zzbsoVar, zzbtpVar, zzbsvVar, zzbvqVar);
        this.m = zzbvjVar;
        this.n = zzbrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void I6() throws RemoteException {
        this.m.j();
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void R(int i2) throws RemoteException {
        this.n.R(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void b1() {
        this.m.r();
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void n0() {
        this.m.j();
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void t5(zzato zzatoVar) {
        this.m.P(zzatoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void v0(zzatq zzatqVar) throws RemoteException {
        this.m.P(new zzato(zzatqVar.getType(), zzatqVar.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
    }
}
