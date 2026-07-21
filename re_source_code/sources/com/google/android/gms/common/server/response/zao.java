package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zao implements Parcelable.Creator<zal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        ArrayList arrayListT = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                arrayListT = SafeParcelReader.t(parcel, iC, zam.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zal(iE, strP, arrayListT);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal[] newArray(int i2) {
        return new zal[i2];
    }
}
