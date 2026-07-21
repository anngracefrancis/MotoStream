package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzac implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        List<Location> listT = LocationResult.f17640f;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 1) {
                SafeParcelReader.K(parcel, iC);
            } else {
                listT = SafeParcelReader.t(parcel, iC, Location.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new LocationResult(listT);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i2) {
        return new LocationResult[i2];
    }
}
