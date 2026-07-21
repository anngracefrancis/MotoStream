package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface zzbjf extends IInterface {
    long E2() throws RemoteException;

    int I3(String str) throws RemoteException;

    String J2() throws RemoteException;

    List L4(String str, String str2) throws RemoteException;

    void N5(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException;

    String O4() throws RemoteException;

    void O5(String str) throws RemoteException;

    void Q4(Bundle bundle) throws RemoteException;

    void V6(String str) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    Map d4(String str, String str2, boolean z) throws RemoteException;

    void e1(Bundle bundle) throws RemoteException;

    String g2() throws RemoteException;

    String l4() throws RemoteException;

    void m0(String str, String str2, Bundle bundle) throws RemoteException;

    String o4() throws RemoteException;

    Bundle s2(Bundle bundle) throws RemoteException;

    void z4(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;
}
