package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaib implements Parcelable.Creator<zzaia> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaia createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String[] strArrQ = null;
        String[] strArrQ2 = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 2) {
                strArrQ = SafeParcelReader.q(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strArrQ2 = SafeParcelReader.q(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaia(strP, strArrQ, strArrQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaia[] newArray(int i2) {
        return new zzaia[i2];
    }
}
