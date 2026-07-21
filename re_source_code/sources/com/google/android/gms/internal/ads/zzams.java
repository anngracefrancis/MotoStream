package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface zzams extends IInterface {
    zzafe F2() throws RemoteException;

    void G4(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException;

    void H4(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException;

    void M3(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException;

    zzang P1() throws RemoteException;

    void Q2(zzxz zzxzVar, String str, String str2) throws RemoteException;

    void Y2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException;

    void a4(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzana b7() throws RemoteException;

    void c6(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException;

    void destroy() throws RemoteException;

    zzand e6() throws RemoteException;

    void f2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void h4(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void o6(zzxz zzxzVar, String str) throws RemoteException;

    void pause() throws RemoteException;

    Bundle r4() throws RemoteException;

    void resume() throws RemoteException;

    void s4(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void w0(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper x1() throws RemoteException;

    boolean x3() throws RemoteException;

    void y2(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException;

    Bundle zzsh() throws RemoteException;
}
