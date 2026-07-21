package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcln implements zzcka<zzbvx, zzams, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbws f15371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbai f15372c;

    public zzcln(Context context, zzbai zzbaiVar, zzbws zzbwsVar) {
        this.a = context;
        this.f15372c = zzbaiVar;
        this.f15371b = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbvx a(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy zzcjyVar) throws RemoteException, zzcmw {
        zzbvy zzbvyVarA = this.f15371b.a(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbvz(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.bl
            private final zzcjy a;

            {
                this.a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.a;
                try {
                    ((zzams) zzcjyVar2.f15313b).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.f15313b).showInterstitial();
                } catch (RemoteException unused) {
                    zzbad.h("Cannot show interstitial.");
                }
            }
        }));
        ((zzcla) zzcjyVar.f15314c).i7(zzbvyVarA.f());
        return zzbvyVarA.h();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        if (this.f15372c.f14328h < 4100000) {
            zzcjyVar.f15313b.Y2(ObjectWrapper.E0(this.a), zzcxuVar.a.a.f15750d, zzcxmVar.s.toString(), (zzamv) zzcjyVar.f15314c);
        } else {
            zzcjyVar.f15313b.c6(ObjectWrapper.E0(this.a), zzcxuVar.a.a.f15750d, zzcxmVar.s.toString(), zzazc.a(zzcxmVar.p), (zzamv) zzcjyVar.f15314c);
        }
    }
}
