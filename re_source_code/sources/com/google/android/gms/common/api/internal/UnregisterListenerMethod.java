package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
    @KeepForSdk
    protected abstract void a(A a, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
