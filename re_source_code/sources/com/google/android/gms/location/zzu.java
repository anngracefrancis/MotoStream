package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzu extends IInterface {
    void P3(LocationAvailability locationAvailability) throws RemoteException;

    void W4(LocationResult locationResult) throws RemoteException;
}
