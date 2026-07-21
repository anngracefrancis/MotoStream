package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zab {
    private final int a;

    public zab(int i2) {
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (PlatformVersion.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void b(Status status);

    public abstract void c(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException;

    public abstract void d(zaab zaabVar, boolean z);

    public abstract void e(RuntimeException runtimeException);
}
