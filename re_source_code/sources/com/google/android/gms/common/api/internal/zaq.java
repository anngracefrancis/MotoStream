package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class zaq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Api<?> f11876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zar f11878h;

    public zaq(Api<?> api, boolean z) {
        this.f11876f = api;
        this.f11877g = z;
    }

    private final void b() {
        Preconditions.l(this.f11878h, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        b();
        this.f11878h.k0(connectionResult, this.f11876f, this.f11877g);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
        b();
        this.f11878h.H(i2);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        b();
        this.f11878h.P(bundle);
    }

    public final void a(zar zarVar) {
        this.f11878h = zarVar;
    }
}
