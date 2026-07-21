package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzaov extends IInterface {
    void K4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException;

    boolean L2(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzapj a6() throws RemoteException;

    void g4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void h5(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException;

    zzapj i5() throws RemoteException;

    void j5(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    void o3(IObjectWrapper iObjectWrapper) throws RemoteException;

    void u3(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException;

    boolean x2(IObjectWrapper iObjectWrapper) throws RemoteException;

    void y6(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException;
}
