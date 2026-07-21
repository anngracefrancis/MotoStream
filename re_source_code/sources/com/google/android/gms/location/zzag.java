package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzag implements Parcelable.Creator<LocationSettingsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        boolean zW = false;
        ArrayList arrayListT = null;
        zzae zzaeVar = null;
        boolean zW2 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                arrayListT = SafeParcelReader.t(parcel, iC, LocationRequest.CREATOR);
            } else if (iV == 2) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 3) {
                zW2 = SafeParcelReader.w(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zzaeVar = (zzae) SafeParcelReader.o(parcel, iC, zzae.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new LocationSettingsRequest(arrayListT, zW, zW2, zzaeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest[] newArray(int i2) {
        return new LocationSettingsRequest[i2];
    }
}
