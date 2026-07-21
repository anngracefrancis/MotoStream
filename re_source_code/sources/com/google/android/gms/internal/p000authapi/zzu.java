package com.google.android.gms.internal.p000authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public interface zzu extends IInterface {
    void K6(Status status) throws RemoteException;

    void L3(Status status, Credential credential) throws RemoteException;

    void P6(Status status, String str) throws RemoteException;
}
