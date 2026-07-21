package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbi implements Parcelable.Creator<zzbh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        double dY = 0.0d;
        double dY2 = 0.0d;
        String strP = null;
        long jG = 0;
        int iE = 0;
        short sI = 0;
        float fA = 0.0f;
        int iE2 = 0;
        int iE3 = -1;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 2:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 3:
                    sI = SafeParcelReader.I(parcel, iC);
                    break;
                case 4:
                    dY = SafeParcelReader.y(parcel, iC);
                    break;
                case 5:
                    dY2 = SafeParcelReader.y(parcel, iC);
                    break;
                case 6:
                    fA = SafeParcelReader.A(parcel, iC);
                    break;
                case 7:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 8:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 9:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzbh(strP, iE, sI, dY, dY2, fA, jG, iE2, iE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh[] newArray(int i2) {
        return new zzbh[i2];
    }
}
