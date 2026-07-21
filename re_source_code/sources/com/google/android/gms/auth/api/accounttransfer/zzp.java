package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzp implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ArrayList<String> arrayListR = null;
        ArrayList<String> arrayListR2 = null;
        ArrayList<String> arrayListR3 = null;
        ArrayList<String> arrayListR4 = null;
        ArrayList<String> arrayListR5 = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 3:
                    arrayListR2 = SafeParcelReader.r(parcel, iC);
                    break;
                case 4:
                    arrayListR3 = SafeParcelReader.r(parcel, iC);
                    break;
                case 5:
                    arrayListR4 = SafeParcelReader.r(parcel, iC);
                    break;
                case 6:
                    arrayListR5 = SafeParcelReader.r(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzo(iE, arrayListR, arrayListR2, arrayListR3, arrayListR4, arrayListR5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i2) {
        return new zzo[i2];
    }
}
