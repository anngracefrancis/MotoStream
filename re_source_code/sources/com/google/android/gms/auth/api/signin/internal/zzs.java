package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public interface zzs extends IInterface {
    void G2(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void Q1(Status status) throws RemoteException;

    void g1(Status status) throws RemoteException;
}
