package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzaem extends IInterface {
    void V(IObjectWrapper iObjectWrapper) throws RemoteException;

    void X0(IObjectWrapper iObjectWrapper, int i2) throws RemoteException;

    void d5(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void destroy() throws RemoteException;

    IObjectWrapper n4(String str) throws RemoteException;

    void x0(IObjectWrapper iObjectWrapper) throws RemoteException;
}
