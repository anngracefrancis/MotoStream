package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzel extends IInterface {
    List<zzv> A2(String str, String str2, zzm zzmVar) throws RemoteException;

    List<zzkj> I1(zzm zzmVar, boolean z) throws RemoteException;

    List<zzkj> K1(String str, String str2, String str3, boolean z) throws RemoteException;

    String P4(zzm zzmVar) throws RemoteException;

    void R6(zzv zzvVar) throws RemoteException;

    byte[] T1(zzan zzanVar, String str) throws RemoteException;

    void U3(zzm zzmVar) throws RemoteException;

    void Z5(zzan zzanVar, zzm zzmVar) throws RemoteException;

    void b4(zzkj zzkjVar, zzm zzmVar) throws RemoteException;

    List<zzkj> f3(String str, String str2, boolean z, zzm zzmVar) throws RemoteException;

    void h2(zzv zzvVar, zzm zzmVar) throws RemoteException;

    void j3(long j2, String str, String str2, String str3) throws RemoteException;

    void j6(zzan zzanVar, String str, String str2) throws RemoteException;

    void r2(zzm zzmVar) throws RemoteException;

    List<zzv> r3(String str, String str2, String str3) throws RemoteException;

    void s6(zzm zzmVar) throws RemoteException;
}
