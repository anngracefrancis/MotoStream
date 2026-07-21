package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzatt extends IInterface {
    void G5(zzaao zzaaoVar) throws RemoteException;

    void K2(zzaue zzaueVar) throws RemoteException;

    void L5(zzatw zzatwVar) throws RemoteException;

    zzatq O6() throws RemoteException;

    void W1(zzxz zzxzVar, zzaub zzaubVar) throws RemoteException;

    void e7(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void f5(IObjectWrapper iObjectWrapper) throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void m2(zzaum zzaumVar) throws RemoteException;
}
