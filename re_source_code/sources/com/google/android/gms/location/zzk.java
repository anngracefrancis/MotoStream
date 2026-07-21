package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzk implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 50;
        long jG2 = Long.MAX_VALUE;
        boolean zW = true;
        float fA = 0.0f;
        int iE = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 2) {
                jG = SafeParcelReader.G(parcel, iC);
            } else if (iV == 3) {
                fA = SafeParcelReader.A(parcel, iC);
            } else if (iV == 4) {
                jG2 = SafeParcelReader.G(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzj(zW, jG, fA, jG2, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i2) {
        return new zzj[i2];
    }
}
