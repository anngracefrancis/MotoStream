package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface zzzk extends IInterface {
    boolean B() throws RemoteException;

    void C2(zzyd zzydVar) throws RemoteException;

    void C3(zzaqt zzaqtVar, String str) throws RemoteException;

    zzyd C5() throws RemoteException;

    void H6(zzado zzadoVar) throws RemoteException;

    zzzs I4() throws RemoteException;

    boolean J4(zzxz zzxzVar) throws RemoteException;

    void L0(zzyz zzyzVar) throws RemoteException;

    void P5(zzzs zzzsVar) throws RemoteException;

    IObjectWrapper S0() throws RemoteException;

    void U5(zzaqn zzaqnVar) throws RemoteException;

    void W6(zzacd zzacdVar) throws RemoteException;

    void X5(zzaax zzaaxVar) throws RemoteException;

    String c0() throws RemoteException;

    void destroy() throws RemoteException;

    String f6() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void h0(zzatb zzatbVar) throws RemoteException;

    void k4() throws RemoteException;

    void m4(String str) throws RemoteException;

    boolean p0() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void t1(boolean z) throws RemoteException;

    void v4(zzzy zzzyVar) throws RemoteException;

    void w4(zzyw zzywVar) throws RemoteException;

    zzyz x5() throws RemoteException;

    void x6() throws RemoteException;

    void z0(zzzp zzzpVar) throws RemoteException;
}
