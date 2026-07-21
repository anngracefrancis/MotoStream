package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes2.dex */
final class d implements BaseGmsClient.BaseConnectionCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient.ConnectionCallbacks f12026f;

    d(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f12026f = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        this.f12026f.H(i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        this.f12026f.P(bundle);
    }
}
