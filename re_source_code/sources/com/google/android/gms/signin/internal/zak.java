package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zak implements Parcelable.Creator<zaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, iC, ConnectionResult.CREATOR);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.o(parcel, iC, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zaj(iE, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj[] newArray(int i2) {
        return new zaj[i2];
    }
}
