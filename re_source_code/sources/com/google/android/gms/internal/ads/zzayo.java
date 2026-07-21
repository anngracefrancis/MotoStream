package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzayo implements Parcelable.Creator<zzaym> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaym createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaym(strP, iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaym[] newArray(int i2) {
        return new zzaym[i2];
    }
}
