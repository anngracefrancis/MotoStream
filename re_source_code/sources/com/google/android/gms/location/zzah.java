package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzah implements Parcelable.Creator<LocationSettingsResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                status = (Status) SafeParcelReader.o(parcel, iC, Status.CREATOR);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.o(parcel, iC, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsResult[] newArray(int i2) {
        return new LocationSettingsResult[i2];
    }
}
