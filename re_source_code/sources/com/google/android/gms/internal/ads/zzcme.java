package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcme implements zzcka<zzbyn, zzams, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbxo f15381b;

    public zzcme(Context context, zzbxo zzbxoVar) {
        this.a = context;
        this.f15381b = zzbxoVar;
    }

    private static boolean c(zzcxu zzcxuVar, int i2) {
        return zzcxuVar.a.a.f15753g.contains(Integer.toString(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) throws RemoteException, zzcmw {
        zzbyt zzbytVarR;
        zzana zzanaVarB7 = ((zzams) zzcjyVar.f15313b).b7();
        zzand zzandVarE6 = ((zzams) zzcjyVar.f15313b).e6();
        zzang zzangVarP1 = ((zzams) zzcjyVar.f15313b).P1();
        if (zzangVarP1 != null && c(zzcxuVar, 6)) {
            zzbytVarR = zzbyt.J(zzangVarP1);
        } else if (zzanaVarB7 != null && c(zzcxuVar, 6)) {
            zzbytVarR = zzbyt.H(zzanaVarB7);
        } else if (zzanaVarB7 != null && c(zzcxuVar, 2)) {
            zzbytVarR = zzbyt.q(zzanaVarB7);
        } else if (zzandVarE6 != null && c(zzcxuVar, 6)) {
            zzbytVarR = zzbyt.I(zzandVarE6);
        } else {
            if (zzandVarE6 == null || !c(zzcxuVar, 1)) {
                throw new zzcmw("No native ad mappers", 0);
            }
            zzbytVarR = zzbyt.r(zzandVarE6);
        }
        if (!zzcxuVar.a.a.f15753g.contains(Integer.toString(zzbytVarR.w()))) {
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        zzbyw zzbywVarB = this.f15381b.b(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbzf(zzbytVarR), new zzcag(zzandVarE6, zzanaVarB7, zzangVarP1));
        ((zzcla) zzcjyVar.f15314c).i7(zzbywVarB.f());
        return zzbywVarB.g();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        zzams zzamsVar = zzcjyVar.f15313b;
        IObjectWrapper iObjectWrapperE0 = ObjectWrapper.E0(this.a);
        zzxz zzxzVar = zzcxuVar.a.a.f15750d;
        String string = zzcxmVar.s.toString();
        String strA = zzazc.a(zzcxmVar.p);
        zzamv zzamvVar = (zzamv) zzcjyVar.f15314c;
        zzcxv zzcxvVar = zzcxuVar.a.a;
        zzamsVar.M3(iObjectWrapperE0, zzxzVar, string, strA, zzamvVar, zzcxvVar.f15755i, zzcxvVar.f15753g);
    }
}
