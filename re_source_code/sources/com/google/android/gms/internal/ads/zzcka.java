package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbsm;

/* JADX INFO: loaded from: classes2.dex */
public interface zzcka<AdT, AdapterT, ListenerT extends zzbsm> {
    AdT a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<AdapterT, ListenerT> zzcjyVar) throws RemoteException, zzcmw;

    void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<AdapterT, ListenerT> zzcjyVar) throws RemoteException;
}
