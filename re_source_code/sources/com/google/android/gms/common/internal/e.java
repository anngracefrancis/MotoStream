package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes2.dex */
final class e implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient.OnConnectionFailedListener f12027f;

    e(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f12027f = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f12027f.E0(connectionResult);
    }
}
