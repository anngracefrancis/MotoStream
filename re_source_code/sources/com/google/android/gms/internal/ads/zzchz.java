package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchz extends zzchx {
    public zzchz(Context context) {
        this.f15261k = new zzarf(context, zzk.zzlu().b(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        synchronized (this.f15257g) {
            if (!this.f15259i) {
                this.f15259i = true;
                try {
                    this.f15261k.e().X6(this.f15260j, new zzchy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.f15256f.c(new zzcie(0));
                } catch (Throwable th) {
                    zzk.zzlk().e(th, "RemoteSignalsClientTask.onConnected");
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
            this.f15256f.k(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jj

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzchz f12828f;

                {
                    this.f12828f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12828f.a();
                }
            }, zzbbm.f14331b);
            return this.f15256f;
        }
    }
}
