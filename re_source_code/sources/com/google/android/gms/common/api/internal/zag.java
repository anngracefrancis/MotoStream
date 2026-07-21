package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class zag<ResultT> extends zac {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskApiCall<Api.AnyClient, ResultT> f11856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource<ResultT> f11857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StatusExceptionMapper f11858d;

    @Override // com.google.android.gms.common.api.internal.zab
    public final void b(Status status) {
        this.f11857c.d(this.f11858d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void c(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            this.f11856b.a(zaaVar.l(), this.f11857c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            b(zab.a(e3));
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void d(zaab zaabVar, boolean z) {
        zaabVar.c(this.f11857c, z);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void e(RuntimeException runtimeException) {
        this.f11857c.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] g(GoogleApiManager.zaa<?> zaaVar) {
        return this.f11856b.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean h(GoogleApiManager.zaa<?> zaaVar) {
        return this.f11856b.b();
    }
}
