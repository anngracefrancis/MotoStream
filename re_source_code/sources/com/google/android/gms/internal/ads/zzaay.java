package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaay implements Parcelable.Creator<zzaax> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaax createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaax(iE);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaax[] newArray(int i2) {
        return new zzaax[i2];
    }
}
