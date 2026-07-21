package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Api.SimpleClient<T> f12015d;

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected T createServiceInterface(IBinder iBinder) {
        return (T) this.f12015d.createServiceInterface(iBinder);
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getServiceDescriptor() {
        return this.f12015d.getServiceDescriptor();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return this.f12015d.getStartServiceAction();
    }

    public Api.SimpleClient<T> j() {
        return this.f12015d;
    }
}
