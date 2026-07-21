package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzs implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        int iE = 0;
        zzt zztVar = null;
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
                hashSet.add(1);
            } else if (iV == 2) {
                zztVar = (zzt) SafeParcelReader.o(parcel, iC, zzt.CREATOR);
                hashSet.add(2);
            } else if (iV == 3) {
                strP = SafeParcelReader.p(parcel, iC);
                hashSet.add(3);
            } else if (iV == 4) {
                strP2 = SafeParcelReader.p(parcel, iC);
                hashSet.add(4);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP3 = SafeParcelReader.p(parcel, iC);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == iL) {
            return new zzr(hashSet, iE, zztVar, strP, strP2, strP3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iL);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i2) {
        return new zzr[i2];
    }
}
