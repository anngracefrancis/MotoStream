package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zae extends com.google.android.gms.internal.base.zab implements zad {
    public zae() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    protected boolean E3(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            X4((ConnectionResult) com.google.android.gms.internal.base.zac.b(parcel, ConnectionResult.CREATOR), (zaa) com.google.android.gms.internal.base.zac.b(parcel, zaa.CREATOR));
        } else if (i2 == 4) {
            K3((Status) com.google.android.gms.internal.base.zac.b(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            W3((Status) com.google.android.gms.internal.base.zac.b(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            W0((Status) com.google.android.gms.internal.base.zac.b(parcel, Status.CREATOR), (GoogleSignInAccount) com.google.android.gms.internal.base.zac.b(parcel, GoogleSignInAccount.CREATOR));
        } else {
            if (i2 != 8) {
                return false;
            }
            w1((zaj) com.google.android.gms.internal.base.zac.b(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
