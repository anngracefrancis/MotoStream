package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class GmsClientEventManager implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GmsClientEventState f11978f;
    private final Handler m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f11979g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f11980h = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f11981i = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f11982j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f11983k = new AtomicInteger(0);
    private boolean l = false;
    private final Object n = new Object();

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        this.f11978f = gmsClientEventState;
        this.m = new zap(looper, this);
    }

    public final void a() {
        this.f11982j = false;
        this.f11983k.incrementAndGet();
    }

    public final void b() {
        this.f11982j = true;
    }

    @VisibleForTesting
    public final void c(ConnectionResult connectionResult) {
        Preconditions.e(this.m, "onConnectionFailure must only be called on the Handler thread");
        this.m.removeMessages(1);
        synchronized (this.n) {
            ArrayList arrayList = new ArrayList(this.f11981i);
            int i2 = this.f11983k.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                if (this.f11982j && this.f11983k.get() == i2) {
                    if (this.f11981i.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.E0(connectionResult);
                    }
                }
                return;
            }
        }
    }

    @VisibleForTesting
    public final void d(Bundle bundle) {
        Preconditions.e(this.m, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.n) {
            boolean z = true;
            Preconditions.n(!this.l);
            this.m.removeMessages(1);
            this.l = true;
            if (this.f11980h.size() != 0) {
                z = false;
            }
            Preconditions.n(z);
            ArrayList arrayList = new ArrayList(this.f11979g);
            int i2 = this.f11983k.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f11982j || !this.f11978f.isConnected() || this.f11983k.get() != i2) {
                    break;
                } else if (!this.f11980h.contains(connectionCallbacks)) {
                    connectionCallbacks.P(bundle);
                }
            }
            this.f11980h.clear();
            this.l = false;
        }
    }

    @VisibleForTesting
    public final void e(int i2) {
        Preconditions.e(this.m, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.m.removeMessages(1);
        synchronized (this.n) {
            this.l = true;
            ArrayList arrayList = new ArrayList(this.f11979g);
            int i3 = this.f11983k.get();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (!this.f11982j || this.f11983k.get() != i3) {
                    break;
                } else if (this.f11979g.contains(connectionCallbacks)) {
                    connectionCallbacks.H(i2);
                }
            }
            this.f11980h.clear();
            this.l = false;
        }
    }

    public final void f(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.k(connectionCallbacks);
        synchronized (this.n) {
            if (this.f11979g.contains(connectionCallbacks)) {
                String strValueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(strValueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11979g.add(connectionCallbacks);
            }
        }
        if (this.f11978f.isConnected()) {
            Handler handler = this.m;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void g(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.k(onConnectionFailedListener);
        synchronized (this.n) {
            if (this.f11981i.contains(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(strValueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f11981i.add(onConnectionFailedListener);
            }
        }
    }

    public final void h(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.k(onConnectionFailedListener);
        synchronized (this.n) {
            if (!this.f11981i.remove(onConnectionFailedListener)) {
                String strValueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(strValueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i2);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.n) {
            if (this.f11982j && this.f11978f.isConnected() && this.f11979g.contains(connectionCallbacks)) {
                connectionCallbacks.P(this.f11978f.getConnectionHint());
            }
        }
        return true;
    }
}
