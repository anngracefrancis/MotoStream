package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzi implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        float fA = 0.0f;
        int iE = 0;
        boolean zW4 = false;
        boolean zW5 = false;
        boolean zW6 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 2:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 3:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 4:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 6:
                    fA = SafeParcelReader.A(parcel, iC);
                    break;
                case 7:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 8:
                    zW4 = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    zW5 = SafeParcelReader.w(parcel, iC);
                    break;
                case 10:
                    zW6 = SafeParcelReader.w(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzh(zW, zW2, strP, zW3, fA, iE, zW4, zW5, zW6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i2) {
        return new zzh[i2];
    }
}
