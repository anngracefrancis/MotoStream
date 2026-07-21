package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckm implements zzcka<zzbnf, zzaov, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzboc f15329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f15330c;

    public zzckm(Context context, zzboc zzbocVar) {
        this.a = context;
        this.f15329b = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbnf a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) throws RemoteException, zzcmw {
        zzboc zzbocVar = this.f15329b;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a);
        View view = this.f15330c;
        zzaov zzaovVar = (zzaov) zzcjyVar.f15313b;
        zzaovVar.getClass();
        zzbng zzbngVarA = zzbocVar.a(zzbprVar, new zzbnk(view, null, mk.a(zzaovVar), zzcxmVar.r.get(0)));
        zzbngVarA.i().Y(this.f15330c);
        ((zzcla) zzcjyVar.f15314c).i7(zzbngVarA.f());
        return zzbngVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.K4(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new ok(this, zzcjyVar), (zzamv) zzcjyVar.f15314c, zzcxuVar.a.a.f15751e);
    }
}
