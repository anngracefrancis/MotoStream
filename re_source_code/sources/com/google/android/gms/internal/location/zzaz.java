package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaz extends zzk {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzas f17092f;

    public zzaz(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, ClientSettings.a(context));
    }

    public zzaz(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, ClientSettings clientSettings) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, clientSettings);
        this.f17092f = new zzas(context, this.f17112e);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        synchronized (this.f17092f) {
            if (isConnected()) {
                try {
                    this.f17092f.a();
                    this.f17092f.c();
                } catch (Exception e2) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e2);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
            throw th;
        }
    }
}
