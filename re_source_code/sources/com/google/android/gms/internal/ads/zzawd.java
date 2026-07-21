package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzawd implements Parcelable.Creator<zzawc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawc createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        zzyd zzydVar = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 2) {
                strP2 = SafeParcelReader.p(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zzydVar = (zzyd) SafeParcelReader.o(parcel, iC, zzyd.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzawc(strP, strP2, zzydVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawc[] newArray(int i2) {
        return new zzawc[i2];
    }
}
