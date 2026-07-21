package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface zzagg extends IInterface {
    void D6() throws RemoteException;

    boolean E(Bundle bundle) throws RemoteException;

    void G0(zzaag zzaagVar) throws RemoteException;

    void L(Bundle bundle) throws RemoteException;

    void W() throws RemoteException;

    void d0(zzagd zzagdVar) throws RemoteException;

    void destroy() throws RemoteException;

    void e0(zzaak zzaakVar) throws RemoteException;

    zzaea f() throws RemoteException;

    String g() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    String h() throws RemoteException;

    String i() throws RemoteException;

    IObjectWrapper j() throws RemoteException;

    void j0() throws RemoteException;

    List k() throws RemoteException;

    zzaei n() throws RemoteException;

    zzaee n2() throws RemoteException;

    String o() throws RemoteException;

    IObjectWrapper r() throws RemoteException;

    double t() throws RemoteException;

    boolean u2() throws RemoteException;

    List u4() throws RemoteException;

    String w() throws RemoteException;

    void z(Bundle bundle) throws RemoteException;
}
