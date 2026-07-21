package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zan implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ArrayList arrayListT = null;
        String strP = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                arrayListT = SafeParcelReader.t(parcel, iC, zal.CREATOR);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zak(iE, arrayListT, strP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i2) {
        return new zak[i2];
    }
}
