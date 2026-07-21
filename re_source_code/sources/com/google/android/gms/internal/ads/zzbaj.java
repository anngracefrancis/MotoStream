package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbaj implements Parcelable.Creator<zzbai> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbai createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        int iE = 0;
        int iE2 = 0;
        boolean zW = false;
        boolean zW2 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 3) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 4) {
                iE2 = SafeParcelReader.E(parcel, iC);
            } else if (iV == 5) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV != 6) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zW2 = SafeParcelReader.w(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzbai(strP, iE, iE2, zW, zW2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbai[] newArray(int i2) {
        return new zzbai[i2];
    }
}
