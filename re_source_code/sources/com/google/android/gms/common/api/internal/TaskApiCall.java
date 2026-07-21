package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11740b = false;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {
        private boolean a = true;

        private Builder() {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
    }

    @KeepForSdk
    protected abstract void a(A a, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean b() {
        return this.f11740b;
    }

    public final Feature[] c() {
        return this.a;
    }
}
