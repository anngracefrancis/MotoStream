package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzacb implements Parcelable.Creator<zzaca> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaca createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 15) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaca(strP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaca[] newArray(int i2) {
        return new zzaca[i2];
    }
}
