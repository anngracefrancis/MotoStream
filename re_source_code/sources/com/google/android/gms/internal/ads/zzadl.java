package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzadl extends IInterface {
    String M5() throws RemoteException;

    String getContent() throws RemoteException;

    void recordClick() throws RemoteException;

    void recordImpression() throws RemoteException;

    void z1(IObjectWrapper iObjectWrapper) throws RemoteException;
}
