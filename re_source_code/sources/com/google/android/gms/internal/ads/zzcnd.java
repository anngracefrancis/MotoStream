package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcnd implements zzcka<zzcdb, zzaov, zzcla> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcdf f15431b;

    public zzcnd(Context context, zzcdf zzcdfVar) {
        this.a = context;
        this.f15431b = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb a(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy zzcjyVar) throws RemoteException, zzcmw {
        final zzcjx zzcjxVar = new zzcjx(zzcxmVar);
        zzcdc zzcdcVarA = this.f15431b.a(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzcdd(new zzbwz(zzcjyVar, zzcjxVar) { // from class: com.google.android.gms.internal.ads.rl
            private final zzcjy a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzcjx f13281b;

            {
                this.a = zzcjyVar;
                this.f13281b = zzcjxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.a;
                zzcjx zzcjxVar2 = this.f13281b;
                try {
                    if (((zzaov) zzcjyVar2.f15313b).L2(ObjectWrapper.E0(context))) {
                        zzcjxVar2.b();
                    } else {
                        zzbad.i("Can't show rewarded video.");
                    }
                } catch (RemoteException e2) {
                    zzbad.d("Can't show rewarded video.", e2);
                }
            }
        }));
        zzcjxVar.a(zzcdcVarA.d());
        ((zzcla) zzcjyVar.f15314c).i7(zzcdcVarA.l());
        return zzcdcVarA.j();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.h5(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new tl(this, zzcjyVar), (zzamv) zzcjyVar.f15314c);
    }
}
