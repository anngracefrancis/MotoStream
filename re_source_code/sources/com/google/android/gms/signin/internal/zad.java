package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public interface zad extends IInterface {
    void K3(Status status) throws RemoteException;

    void W0(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void W3(Status status) throws RemoteException;

    void X4(ConnectionResult connectionResult, zaa zaaVar) throws RemoteException;

    void w1(zaj zajVar) throws RemoteException;
}
