package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: loaded from: classes2.dex */
public interface zaf extends IInterface {
    void B1(int i2) throws RemoteException;

    void V2(IAccountAccessor iAccountAccessor, int i2, boolean z) throws RemoteException;

    void n3(zah zahVar, zad zadVar) throws RemoteException;
}
