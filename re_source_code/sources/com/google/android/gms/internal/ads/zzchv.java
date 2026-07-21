package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchv extends zzchx {
    public zzchv(Context context) {
        this.f15261k = new zzarf(context, zzk.zzlu().b(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzchx, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        zzbad.e("Cannot connect to remote service, fallback to local instance.");
        this.f15256f.c(new zzcie(0));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        synchronized (this.f15257g) {
            if (!this.f15259i) {
                this.f15259i = true;
                try {
                    this.f15261k.e().I5(this.f15260j, new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.f15256f.c(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().e(th, "RemoteAdRequestClientTask.onConnected");
                    this.f15256f.c(new zzcie(0));
                }
            }
        }
    }

    public final zzbbh<InputStream> b(zzarx zzarxVar) {
        synchronized (this.f15257g) {
            if (this.f15258h) {
                return this.f15256f;
            }
            this.f15258h = true;
            this.f15260j = zzarxVar;
            this.f15261k.checkAvailabilityAndConnect();
            this.f15256f.k(new Runnable(this) { // from class: com.google.android.gms.internal.ads.hj

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzchv f12715f;

                {
                    this.f12715f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12715f.a();
                }
            }, zzbbm.f14331b);
            return this.f15256f;
        }
    }
}
