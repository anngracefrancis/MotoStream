package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

/* JADX INFO: loaded from: classes2.dex */
public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A f11853b;

    public zae(int i2, A a) {
        super(i2);
        this.f11853b = a;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void b(Status status) {
        this.f11853b.y(status);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void c(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            this.f11853b.w(zaaVar.l());
        } catch (RuntimeException e2) {
            e(e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void d(zaab zaabVar, boolean z) {
        zaabVar.b(this.f11853b, z);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void e(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f11853b.y(new Status(10, sb.toString()));
    }
}
