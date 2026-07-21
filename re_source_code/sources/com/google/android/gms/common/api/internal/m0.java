package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
abstract class m0<T> extends zac {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final TaskCompletionSource<T> f11771b;

    public m0(int i2, TaskCompletionSource<T> taskCompletionSource) {
        super(i2);
        this.f11771b = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void b(Status status) {
        this.f11771b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void c(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            i(zaaVar);
        } catch (DeadObjectException e2) {
            b(zab.a(e2));
            throw e2;
        } catch (RemoteException e3) {
            b(zab.a(e3));
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void e(RuntimeException runtimeException) {
        this.f11771b.d(runtimeException);
    }

    protected abstract void i(GoogleApiManager.zaa<?> zaaVar) throws RemoteException;
}
