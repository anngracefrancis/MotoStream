package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface zzafa extends IInterface {
    zzaei D0() throws RemoteException;

    boolean E(Bundle bundle) throws RemoteException;

    void L(Bundle bundle) throws RemoteException;

    void destroy() throws RemoteException;

    zzaea f() throws RemoteException;

    String g() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    String h() throws RemoteException;

    String i() throws RemoteException;

    IObjectWrapper j() throws RemoteException;

    List k() throws RemoteException;

    IObjectWrapper r() throws RemoteException;

    String w() throws RemoteException;

    void z(Bundle bundle) throws RemoteException;
}
