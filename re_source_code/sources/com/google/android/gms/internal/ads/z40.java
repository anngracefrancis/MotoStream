package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
final class z40 implements BaseGmsClient.BaseConnectionCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvv f13680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzwb f13682h;

    z40(zzwb zzwbVar, zzvv zzvvVar, zzbbr zzbbrVar) {
        this.f13682h = zzwbVar;
        this.f13680f = zzvvVar;
        this.f13681g = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        synchronized (this.f13682h.f16871d) {
            if (this.f13682h.f16869b) {
                return;
            }
            zzwb.c(this.f13682h, true);
            final zzvu zzvuVar = this.f13682h.a;
            if (zzvuVar == null) {
                return;
            }
            final zzvv zzvvVar = this.f13680f;
            final zzbbr zzbbrVar = this.f13681g;
            final zzbbh<?> zzbbhVarB = zzaxg.b(new Runnable(this, zzvuVar, zzvvVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.a50

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final z40 f12219f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final zzvu f12220g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final zzvv f12221h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private final zzbbr f12222i;

                {
                    this.f12219f = this;
                    this.f12220g = zzvuVar;
                    this.f12221h = zzvvVar;
                    this.f12222i = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    z40 z40Var = this.f12219f;
                    zzvu zzvuVar2 = this.f12220g;
                    zzvv zzvvVar2 = this.f12221h;
                    zzbbr zzbbrVar2 = this.f12222i;
                    try {
                        zzvs zzvsVarF4 = zzvuVar2.e().F4(zzvvVar2);
                        if (!zzvsVarF4.y()) {
                            zzbbrVar2.c(new RuntimeException("No entry contents."));
                            z40Var.f13682h.a();
                            return;
                        }
                        c50 c50Var = new c50(z40Var, zzvsVarF4.z(), 1);
                        int i2 = c50Var.read();
                        if (i2 == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        c50Var.unread(i2);
                        zzbbrVar2.a(c50Var);
                    } catch (RemoteException | IOException e2) {
                        zzbad.c("Unable to obtain a cache service instance.", e2);
                        zzbbrVar2.c(e2);
                        z40Var.f13682h.a();
                    }
                }
            });
            final zzbbr zzbbrVar2 = this.f13681g;
            zzbbrVar2.k(new Runnable(zzbbrVar2, zzbbhVarB) { // from class: com.google.android.gms.internal.ads.b50

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbbr f12316f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final Future f12317g;

                {
                    this.f12316f = zzbbrVar2;
                    this.f12317g = zzbbhVarB;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbr zzbbrVar3 = this.f12316f;
                    Future future = this.f12317g;
                    if (zzbbrVar3.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbbm.f14331b);
        }
    }
}
