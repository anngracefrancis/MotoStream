package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzab implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 3600000;
        long jG2 = 600000;
        long jG3 = Long.MAX_VALUE;
        long jG4 = 0;
        int iE = 102;
        boolean zW = false;
        int iE2 = Integer.MAX_VALUE;
        float fA = 0.0f;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 3:
                    jG2 = SafeParcelReader.G(parcel, iC);
                    break;
                case 4:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 5:
                    jG3 = SafeParcelReader.G(parcel, iC);
                    break;
                case 6:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 7:
                    fA = SafeParcelReader.A(parcel, iC);
                    break;
                case 8:
                    jG4 = SafeParcelReader.G(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new LocationRequest(iE, jG, jG2, zW, jG3, iE2, fA, jG4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}
