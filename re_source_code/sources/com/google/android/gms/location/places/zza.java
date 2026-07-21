package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zza implements Parcelable.Creator<PlaceReport> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 3) {
                strP2 = SafeParcelReader.p(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP3 = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new PlaceReport(iE, strP, strP2, strP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport[] newArray(int i2) {
        return new PlaceReport[i2];
    }
}
