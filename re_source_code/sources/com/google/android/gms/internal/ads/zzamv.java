package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzamv extends IInterface {
    void F0(zzafe zzafeVar, String str) throws RemoteException;

    void I6() throws RemoteException;

    void R(int i2) throws RemoteException;

    void b1() throws RemoteException;

    void k1(zzamy zzamyVar) throws RemoteException;

    void m3(String str) throws RemoteException;

    void n0() throws RemoteException;

    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i2) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void t5(zzato zzatoVar) throws RemoteException;

    void v0(zzatq zzatqVar) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;
}
