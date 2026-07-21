package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaiz implements Parcelable.Creator<zzaiy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiy createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 1) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaiy(iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiy[] newArray(int i2) {
        return new zzaiy[i2];
    }
}
