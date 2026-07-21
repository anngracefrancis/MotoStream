package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface> extends GmsClient<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GmsClientEventManager f11990d;

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void checkAvailabilityAndConnect() {
        this.f11990d.b();
        super.checkAvailabilityAndConnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void disconnect() {
        this.f11990d.a();
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onConnectedLocked(T t) {
        super.onConnectedLocked(t);
        this.f11990d.d(getConnectionHint());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.f11990d.c(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onConnectionSuspended(int i2) {
        super.onConnectionSuspended(i2);
        this.f11990d.e(i2);
    }
}
