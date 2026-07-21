package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface IGmsCallbacks extends IInterface {
    void O3(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void f4(int i2, IBinder iBinder, zzj zzjVar) throws RemoteException;

    void v2(int i2, Bundle bundle) throws RemoteException;
}
