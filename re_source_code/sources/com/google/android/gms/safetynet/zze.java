package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zze implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        int iE = 0;
        boolean zW = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                jG = SafeParcelReader.G(parcel, iC);
            } else if (iV == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) SafeParcelReader.s(parcel, iC, HarmfulAppsData.CREATOR);
            } else if (iV == 4) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zW = SafeParcelReader.w(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzd(jG, harmfulAppsDataArr, iE, zW);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i2) {
        return new zzd[i2];
    }
}
