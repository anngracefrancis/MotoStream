package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzh extends zzb implements zzg {
    public zzh() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        y0((Status) zzc.a(parcel, Status.CREATOR));
        return true;
    }
}
