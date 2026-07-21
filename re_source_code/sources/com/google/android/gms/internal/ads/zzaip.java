package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaip implements Parcelable.Creator<zzaio> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaio createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        boolean zW = false;
        String strP = null;
        String strP2 = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 2) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 3) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP2 = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaio(strP, zW, iE, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaio[] newArray(int i2) {
        return new zzaio[i2];
    }
}
