package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzchx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final zzbbr<InputStream> f15256f = new zzbbr<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Object f15257g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f15258h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f15259i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected zzarx f15260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected zzarf f15261k;

    public void E0(ConnectionResult connectionResult) {
        zzbad.e("Disconnected from remote ad request service.");
        this.f15256f.c(new zzcie(0));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void H(int i2) {
        zzbad.e("Cannot connect to remote service, fallback to local instance.");
    }

    protected final void a() {
        synchronized (this.f15257g) {
            this.f15259i = true;
            if (this.f15261k.isConnected() || this.f15261k.isConnecting()) {
                this.f15261k.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
