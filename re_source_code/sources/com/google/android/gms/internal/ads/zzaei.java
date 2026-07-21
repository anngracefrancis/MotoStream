package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzaei extends IInterface {
    Uri I0() throws RemoteException;

    double T3() throws RemoteException;

    int getHeight() throws RemoteException;

    int getWidth() throws RemoteException;

    IObjectWrapper t4() throws RemoteException;
}
