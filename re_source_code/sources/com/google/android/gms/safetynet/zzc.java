package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<HarmfulAppsData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HarmfulAppsData createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        byte[] bArrG = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 3) {
                bArrG = SafeParcelReader.g(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new HarmfulAppsData(strP, bArrG, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HarmfulAppsData[] newArray(int i2) {
        return new HarmfulAppsData[i2];
    }
}
