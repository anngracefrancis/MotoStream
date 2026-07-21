package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzag implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        byte[] bArrG = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bArrG = SafeParcelReader.g(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaf(iE, strP, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i2) {
        return new zzaf[i2];
    }
}
