package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface zzafe extends IInterface {
    boolean F3(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzaei N1(String str) throws RemoteException;

    IObjectWrapper U4() throws RemoteException;

    String Y0(String str) throws RemoteException;

    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    IObjectWrapper r() throws RemoteException;

    void recordImpression() throws RemoteException;
}
