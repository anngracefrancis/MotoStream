package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zap implements Parcelable.Creator<SafeParcelResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Parcel parcelM = null;
        zak zakVar = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                parcelM = SafeParcelReader.m(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zakVar = (zak) SafeParcelReader.o(parcel, iC, zak.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new SafeParcelResponse(iE, parcelM, zakVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }
}
