package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcig extends zzarn {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f15265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzasm f15266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzasl f15267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzblp f15268j;

    public zzcig(Context context, Executor executor, zzasm zzasmVar, zzblp zzblpVar, zzasl zzaslVar) {
        zzacu.a(context);
        this.f15264f = context;
        this.f15265g = executor;
        this.f15266h = zzasmVar;
        this.f15267i = zzaslVar;
        this.f15268j = zzblpVar;
    }

    private final void h7(zzbbh<InputStream> zzbbhVar, zzarr zzarrVar) {
        zzbar.f(zzbar.c(zzbbhVar, new zzbal(this) { // from class: com.google.android.gms.internal.ads.tj
            private final zzcig a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(zzcyc.c((InputStream) obj));
            }
        }, zzaxg.a), new uj(this, zzarrVar), zzbbm.f14331b);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void I5(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> zzbbhVarJ7 = j7(zzarxVar);
        h7(zzbbhVarJ7, zzarrVar);
        zzbbhVarJ7.k(new Runnable(this) { // from class: com.google.android.gms.internal.ads.rj

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcig f13277f;

            {
                this.f13277f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13277f.i7();
            }
        }, this.f15265g);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void W5(zzarg zzargVar, zzarp zzarpVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void X6(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> zzbbhVarF;
        zzalr zzalrVarA = zzk.zzlt().a(this.f15264f, zzbai.y());
        if (((Boolean) zzyt.e().c(zzacu.K4)).booleanValue()) {
            zzcvs zzcvsVarA = this.f15268j.a(zzarxVar);
            final zzcvb<JSONObject> zzcvbVarB = this.f15268j.a(zzarxVar).b();
            zzbbhVarF = zzcvsVarA.c().c(zzczs.GET_SIGNALS, zzbar.o(zzarxVar.f14104f)).b(new zzbal(zzcvbVarB) { // from class: com.google.android.gms.internal.ads.sj
                private final zzcvb a;

                {
                    this.a = zzcvbVarB;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.a.b(zzk.zzlg().N((Bundle) obj));
                }
            }).j(zzczs.JS_SIGNALS).b(zzalrVarA.a("google.afma.request.getSignals", zzalo.f13955b, zzalo.f13956c)).f();
        } else {
            zzbbhVarF = zzbar.l(new Exception("Signal collection disabled."));
        }
        h7(zzbbhVarF, zzarrVar);
    }

    final /* synthetic */ void i7() {
        zzbao.a(this.f15267i.a(), "persistFlags");
    }

    public final zzbbh<InputStream> j7(zzarx zzarxVar) {
        zzalr zzalrVarA = zzk.zzlt().a(this.f15264f, zzbai.y());
        final zzcvs zzcvsVarA = this.f15268j.a(zzarxVar);
        zzbal zzbalVar = new zzbal(zzcvsVarA) { // from class: com.google.android.gms.internal.ads.lj
            private final zzcvs a;

            {
                this.a = zzcvsVarA;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a().b(zzk.zzlg().N((Bundle) obj));
            }
        };
        zzczc zzczcVar = mj.a;
        zzaln<JSONObject> zzalnVar = zzalo.f13955b;
        zzalj zzaljVarA = zzalrVarA.a("AFMA_getAdDictionary", zzalnVar, nj.a);
        zzalj zzaljVarA2 = zzalrVarA.a("google.afma.response.normalize", zzcir.a, zzalo.f13956c);
        zzciu zzciuVar = new zzciu(this.f15264f, zzarxVar.f14105g.f14326f, this.f15266h, zzarxVar.l);
        zzczt zzcztVarC = zzcvsVarA.c();
        final zzcze zzczeVarF = zzcztVarC.c(zzczs.GMS_SIGNALS, zzbar.o(zzarxVar.f14104f)).b(zzbalVar).h(zzczcVar).f();
        if (((Boolean) zzyt.e().c(zzacu.w4)).booleanValue()) {
            return zzcztVarC.c(zzczs.AD_REQUEST, zzczeVarF).b(zzalrVarA.a("google.afma.request.getAdResponse", zzalnVar, zzalnVar)).h(oj.a).f();
        }
        final zzcze zzczeVarF2 = zzcztVarC.c(zzczs.BUILD_URL, zzczeVarF).b(zzaljVarA).f();
        final zzcze zzczeVarF3 = zzcztVarC.b(zzczs.HTTP, zzczeVarF2, zzczeVarF).a(new Callable(zzczeVarF, zzczeVarF2) { // from class: com.google.android.gms.internal.ads.pj

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f13173f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13174g;

            {
                this.f13173f = zzczeVarF;
                this.f13174g = zzczeVarF2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzciv((JSONObject) this.f13173f.get(), (zzasd) this.f13174g.get());
            }
        }).h(zzciuVar).f();
        return zzcztVarC.b(zzczs.PRE_PROCESS, zzczeVarF, zzczeVarF2, zzczeVarF3).a(new Callable(zzczeVarF3, zzczeVarF, zzczeVarF2) { // from class: com.google.android.gms.internal.ads.qj

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f13234f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbbh f13235g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzbbh f13236h;

            {
                this.f13234f = zzczeVarF3;
                this.f13235g = zzczeVarF;
                this.f13236h = zzczeVarF2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcir((zzciw) this.f13234f.get(), (JSONObject) this.f13235g.get(), (zzasd) this.f13236h.get());
            }
        }).b(zzaljVarA2).f();
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final zzari r6(zzarg zzargVar) throws RemoteException {
        return null;
    }
}
