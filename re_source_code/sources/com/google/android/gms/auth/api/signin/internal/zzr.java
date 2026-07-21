package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzr extends com.google.android.gms.internal.p000authapi.zzd implements zzq {
    public zzr() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zzd
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            v();
        } else {
            if (i2 != 2) {
                return false;
            }
            O();
        }
        return true;
    }
}
