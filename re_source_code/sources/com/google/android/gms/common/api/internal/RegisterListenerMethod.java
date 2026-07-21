package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder<L> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Feature[] f11737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11738c;

    @KeepForSdk
    public void a() {
        this.a.a();
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> b() {
        return this.a.b();
    }

    @KeepForSdk
    public Feature[] c() {
        return this.f11737b;
    }

    @KeepForSdk
    protected abstract void d(A a, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final boolean e() {
        return this.f11738c;
    }
}
