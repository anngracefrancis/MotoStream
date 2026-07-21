package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        int iE = 0;
        ArrayList arrayListT = null;
        zzo zzoVar = null;
        int iE2 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
                hashSet.add(1);
            } else if (iV == 2) {
                arrayListT = SafeParcelReader.t(parcel, iC, zzr.CREATOR);
                hashSet.add(2);
            } else if (iV == 3) {
                iE2 = SafeParcelReader.E(parcel, iC);
                hashSet.add(3);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zzoVar = (zzo) SafeParcelReader.o(parcel, iC, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == iL) {
            return new zzl(hashSet, iE, arrayListT, iE2, zzoVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iL);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i2) {
        return new zzl[i2];
    }
}
