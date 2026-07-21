package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zab implements Parcelable.Creator<ClientIdentity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientIdentity createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        String strP = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new ClientIdentity(iE, strP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientIdentity[] newArray(int i2) {
        return new ClientIdentity[i2];
    }
}
