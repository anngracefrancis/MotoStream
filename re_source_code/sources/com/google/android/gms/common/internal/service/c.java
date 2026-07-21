package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes2.dex */
final class c extends zaa {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f12051f;

    public c(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f12051f = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zaj
    public final void z2(int i2) throws RemoteException {
        this.f12051f.a(new Status(i2));
    }
}
