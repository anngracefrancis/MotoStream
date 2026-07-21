package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzy extends zzb implements zzx {
    public zzy() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                J5((Status) zzc.a(parcel, Status.CREATOR));
                return true;
            case 2:
                Q0((Status) zzc.a(parcel, Status.CREATOR), (com.google.android.gms.auth.api.accounttransfer.zzt) zzc.a(parcel, com.google.android.gms.auth.api.accounttransfer.zzt.CREATOR));
                return true;
            case 3:
                j1((Status) zzc.a(parcel, Status.CREATOR), (zzl) zzc.a(parcel, zzl.CREATOR));
                return true;
            case 4:
                d();
                return true;
            case 5:
                R5((Status) zzc.a(parcel, Status.CREATOR));
                return true;
            case 6:
                i0(parcel.createByteArray());
                return true;
            case 7:
                S2((DeviceMetaData) zzc.a(parcel, DeviceMetaData.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
