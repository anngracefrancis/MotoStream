package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnw implements zzcka<zzcdb, zzams, zzclb> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f15452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcdf f15453c;

    public zzcnw(Context context, Executor executor, zzcdf zzcdfVar) {
        this.a = context;
        this.f15452b = executor;
        this.f15453c = zzcdfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzclb> zzcjyVar) {
        try {
            zzcjyVar.f15313b.o6(zzcxuVar.a.a.f15750d, zzcxmVar.s.toString());
        } catch (Exception e2) {
            String strValueOf = String.valueOf(zzcjyVar.a);
            zzbad.d(strValueOf.length() != 0 ? "Fail to load ad from adapter ".concat(strValueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb a(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy zzcjyVar) throws RemoteException, zzcmw {
        zzcdc zzcdcVarA = this.f15453c.a(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzcdd(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.dm
            private final zzcjy a;

            {
                this.a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.a;
                try {
                    ((zzams) zzcjyVar2.f15313b).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.f15313b).showVideo();
                } catch (RemoteException e2) {
                    zzbad.d("Cannot show rewarded video.", e2);
                }
            }
        }));
        zzcdcVarA.a().V(new zzccy((zzams) zzcjyVar.f15313b), this.f15452b);
        zzbse zzbseVarB = zzcdcVarA.b();
        zzbri zzbriVarC = zzcdcVarA.c();
        ((zzclb) zzcjyVar.f15314c).i7(new hm(this, zzcdcVarA.h(), zzbriVarC, zzbseVarB, zzcdcVarA.k()));
        return zzcdcVarA.j();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzclb> zzcjyVar) throws RemoteException {
        if (zzcjyVar.f15313b.isInitialized()) {
            e(zzcxuVar, zzcxmVar, zzcjyVar);
            return;
        }
        ((zzclb) zzcjyVar.f15314c).j7(new em(this, zzcxuVar, zzcxmVar, zzcjyVar));
        zzcjyVar.f15313b.h4(ObjectWrapper.E0(this.a), zzcxuVar.a.a.f15750d, null, (zzatk) zzcjyVar.f15314c, zzcxmVar.s.toString());
    }
}
