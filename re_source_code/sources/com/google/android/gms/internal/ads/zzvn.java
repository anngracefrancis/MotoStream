package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzvn {
    private final Runnable a = new u40(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f16858b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzvu f16859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f16860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzvy f16861e;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.f16858b) {
            if (this.f16860d != null && this.f16859c == null) {
                zzvu zzvuVarE = e(new w40(this), new x40(this));
                this.f16859c = zzvuVarE;
                zzvuVarE.checkAvailabilityAndConnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        synchronized (this.f16858b) {
            zzvu zzvuVar = this.f16859c;
            if (zzvuVar == null) {
                return;
            }
            if (zzvuVar.isConnected() || this.f16859c.isConnecting()) {
                this.f16859c.disconnect();
            }
            this.f16859c = null;
            this.f16861e = null;
            Binder.flushPendingCommands();
        }
    }

    @VisibleForTesting
    private final synchronized zzvu e(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzvu(this.f16860d, zzk.zzlu().b(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    static /* synthetic */ zzvu f(zzvn zzvnVar, zzvu zzvuVar) {
        zzvnVar.f16859c = null;
        return null;
    }

    public final void c(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.f16858b) {
            if (this.f16860d != null) {
                return;
            }
            this.f16860d = context.getApplicationContext();
            if (((Boolean) zzyt.e().c(zzacu.v3)).booleanValue()) {
                a();
            } else {
                if (((Boolean) zzyt.e().c(zzacu.u3)).booleanValue()) {
                    zzk.zzlj().d(new v40(this));
                }
            }
        }
    }

    public final zzvs d(zzvv zzvvVar) {
        synchronized (this.f16858b) {
            zzvy zzvyVar = this.f16861e;
            if (zzvyVar == null) {
                return new zzvs();
            }
            try {
                return zzvyVar.F4(zzvvVar);
            } catch (RemoteException e2) {
                zzbad.c("Unable to call into cache service.", e2);
                return new zzvs();
            }
        }
    }

    public final void l() {
        if (((Boolean) zzyt.e().c(zzacu.w3)).booleanValue()) {
            synchronized (this.f16858b) {
                a();
                zzk.zzlg();
                Handler handler = zzaxi.a;
                handler.removeCallbacks(this.a);
                zzk.zzlg();
                handler.postDelayed(this.a, ((Long) zzyt.e().c(zzacu.x3)).longValue());
            }
        }
    }
}
