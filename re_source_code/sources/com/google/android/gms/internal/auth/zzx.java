package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public interface zzx extends IInterface {
    void J5(Status status) throws RemoteException;

    void Q0(Status status, com.google.android.gms.auth.api.accounttransfer.zzt zztVar) throws RemoteException;

    void R5(Status status) throws RemoteException;

    void S2(DeviceMetaData deviceMetaData) throws RemoteException;

    void d() throws RemoteException;

    void i0(byte[] bArr) throws RemoteException;

    void j1(Status status, zzl zzlVar) throws RemoteException;
}
