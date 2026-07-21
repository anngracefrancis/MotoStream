package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaa implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        zzaj[] zzajVarArr = null;
        int iE = 1000;
        int iE2 = 1;
        int iE3 = 1;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE2 = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                iE3 = SafeParcelReader.E(parcel, iC);
            } else if (iV == 3) {
                jG = SafeParcelReader.G(parcel, iC);
            } else if (iV == 4) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zzajVarArr = (zzaj[]) SafeParcelReader.s(parcel, iC, zzaj.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new LocationAvailability(iE, iE2, iE3, jG, zzajVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i2) {
        return new LocationAvailability[i2];
    }
}
