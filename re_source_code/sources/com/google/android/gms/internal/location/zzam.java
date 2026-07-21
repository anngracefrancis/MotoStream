package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzam extends IInterface {
    void Q5(int i2, String[] strArr) throws RemoteException;

    void f7(int i2, String[] strArr) throws RemoteException;

    void v3(int i2, PendingIntent pendingIntent) throws RemoteException;
}
