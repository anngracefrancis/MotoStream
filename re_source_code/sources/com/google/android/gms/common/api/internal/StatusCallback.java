package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class StatusCallback extends IStatusCallback.Stub {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> f11739f;

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void p2(Status status) {
        this.f11739f.a(status);
    }
}
