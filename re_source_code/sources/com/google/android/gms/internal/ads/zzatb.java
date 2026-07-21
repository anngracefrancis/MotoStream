package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzatb extends IInterface {
    void l1(zzasr zzasrVar) throws RemoteException;

    void onRewardedVideoAdClosed() throws RemoteException;

    void onRewardedVideoAdFailedToLoad(int i2) throws RemoteException;

    void onRewardedVideoAdLeftApplication() throws RemoteException;

    void onRewardedVideoAdLoaded() throws RemoteException;

    void onRewardedVideoAdOpened() throws RemoteException;

    void onRewardedVideoCompleted() throws RemoteException;

    void onRewardedVideoStarted() throws RemoteException;
}
