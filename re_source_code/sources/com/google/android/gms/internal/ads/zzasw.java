package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzasw extends IInterface {
    void M6(IObjectWrapper iObjectWrapper) throws RemoteException;

    void T4(zzasu zzasuVar) throws RemoteException;

    void T5(IObjectWrapper iObjectWrapper) throws RemoteException;

    void d2(IObjectWrapper iObjectWrapper) throws RemoteException;

    void destroy() throws RemoteException;

    void g5(String str) throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    void h0(zzatb zzatbVar) throws RemoteException;

    void i4(zzath zzathVar) throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void s0(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void z0(zzzp zzzpVar) throws RemoteException;
}
