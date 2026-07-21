package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzv extends zzd implements zzu {
    public zzv() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzd
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            L3((Status) zze.a(parcel, Status.CREATOR), (Credential) zze.a(parcel, Credential.CREATOR));
        } else if (i2 == 2) {
            K6((Status) zze.a(parcel, Status.CREATOR));
        } else {
            if (i2 != 3) {
                return false;
            }
            P6((Status) zze.a(parcel, Status.CREATOR), parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
