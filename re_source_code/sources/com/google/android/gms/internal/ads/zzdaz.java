package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdaz implements Parcelable.Creator<zzday> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzday createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bArrG = SafeParcelReader.g(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzday(iE, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzday[] newArray(int i2) {
        return new zzday[i2];
    }
}
