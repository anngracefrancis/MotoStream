package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmg implements zzcka<zzbyn, zzaov, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbxo f15383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzang f15384c;

    public zzcmg(Context context, zzbxo zzbxoVar) {
        this.a = context;
        this.f15383b = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) throws RemoteException, zzcmw {
        if (!zzcxuVar.a.a.f15753g.contains(Integer.toString(6))) {
            throw new zzcmw("Unified must be used for RTB.", 1);
        }
        zzbyt zzbytVarJ = zzbyt.J(this.f15384c);
        if (!zzcxuVar.a.a.f15753g.contains(Integer.toString(zzbytVarJ.w()))) {
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        zzbyw zzbywVarB = this.f15383b.b(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbzf(zzbytVarJ), new zzcag(null, null, this.f15384c));
        ((zzcla) zzcjyVar.f15314c).i7(zzbywVarB.f());
        return zzbywVarB.g();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.g4(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new ml(this, zzcjyVar), (zzamv) zzcjyVar.f15314c);
    }
}
