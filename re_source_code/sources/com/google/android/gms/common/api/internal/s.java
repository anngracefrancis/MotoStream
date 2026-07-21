package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class s implements GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f11789f;

    s(zaaw zaawVar, StatusPendingResult statusPendingResult) {
        this.f11789f = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f11789f.k(new Status(8));
    }
}
