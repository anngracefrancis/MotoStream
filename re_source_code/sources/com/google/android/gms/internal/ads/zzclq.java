package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzclq implements zzcka<zzbvx, zzaov, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbws f15375b;

    public zzclq(Context context, zzbws zzbwsVar) {
        this.a = context;
        this.f15375b = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbvx a(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy zzcjyVar) throws RemoteException, zzcmw {
        final zzcjx zzcjxVar = new zzcjx(zzcxmVar);
        zzbvy zzbvyVarA = this.f15375b.a(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbvz(new zzbwz(zzcjyVar, zzcjxVar) { // from class: com.google.android.gms.internal.ads.cl
            private final zzcjy a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzcjx f12432b;

            {
                this.a = zzcjyVar;
                this.f12432b = zzcjxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.a;
                zzcjx zzcjxVar2 = this.f12432b;
                try {
                    if (((zzaov) zzcjyVar2.f15313b).x2(ObjectWrapper.E0(context))) {
                        zzcjxVar2.b();
                    } else {
                        zzbad.i("Cannot show interstitial.");
                    }
                } catch (RemoteException e2) {
                    zzbad.d("Cannot show interstitial.", e2);
                }
            }
        }));
        zzcjxVar.a(zzbvyVarA.d());
        ((zzcla) zzcjyVar.f15314c).i7(zzbvyVarA.f());
        return zzbvyVarA.h();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.y6(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new el(this, zzcjyVar), (zzamv) zzcjyVar.f15314c);
    }
}
