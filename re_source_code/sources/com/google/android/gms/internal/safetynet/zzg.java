package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;

/* JADX INFO: loaded from: classes2.dex */
public interface zzg extends IInterface {
    void A6(Status status, boolean z) throws RemoteException;

    void E5(Status status, boolean z) throws RemoteException;

    void H2(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    void H5(Status status, com.google.android.gms.safetynet.zzh zzhVar) throws RemoteException;

    void R3(Status status, zzf zzfVar) throws RemoteException;

    void s1(Status status, com.google.android.gms.safetynet.zza zzaVar) throws RemoteException;

    void s5(Status status, zzd zzdVar) throws RemoteException;

    void u(String str) throws RemoteException;

    void y0(Status status) throws RemoteException;
}
