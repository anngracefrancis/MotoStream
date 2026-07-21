package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzaja extends IInterface {
    void destroy() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void m6(IObjectWrapper iObjectWrapper, zzajc zzajcVar) throws RemoteException;
}
