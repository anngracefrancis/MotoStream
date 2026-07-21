package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzo implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        long jG2 = 0;
        long jG3 = 0;
        long jG4 = 0;
        long jG5 = 0;
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        String strP4 = null;
        String strP5 = null;
        String strP6 = null;
        String strP7 = null;
        Boolean boolX = null;
        ArrayList<String> arrayListR = null;
        String strP8 = null;
        long jG6 = -2147483648L;
        boolean zW = true;
        boolean zW2 = false;
        int iE = 0;
        boolean zW3 = true;
        boolean zW4 = true;
        boolean zW5 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 2:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 3:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 4:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 6:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 7:
                    jG2 = SafeParcelReader.G(parcel, iC);
                    break;
                case 8:
                    strP5 = SafeParcelReader.p(parcel, iC);
                    break;
                case 9:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 10:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 11:
                    jG6 = SafeParcelReader.G(parcel, iC);
                    break;
                case 12:
                    strP6 = SafeParcelReader.p(parcel, iC);
                    break;
                case 13:
                    jG3 = SafeParcelReader.G(parcel, iC);
                    break;
                case 14:
                    jG4 = SafeParcelReader.G(parcel, iC);
                    break;
                case 15:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 16:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 17:
                    zW4 = SafeParcelReader.w(parcel, iC);
                    break;
                case 18:
                    zW5 = SafeParcelReader.w(parcel, iC);
                    break;
                case 19:
                    strP7 = SafeParcelReader.p(parcel, iC);
                    break;
                case 20:
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
                case 21:
                    boolX = SafeParcelReader.x(parcel, iC);
                    break;
                case 22:
                    jG5 = SafeParcelReader.G(parcel, iC);
                    break;
                case 23:
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 24:
                    strP8 = SafeParcelReader.p(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzm(strP, strP2, strP3, strP4, jG, jG2, strP5, zW, zW2, jG6, strP6, jG3, jG4, iE, zW3, zW4, zW5, strP7, boolX, jG5, arrayListR, strP8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i2) {
        return new zzm[i2];
    }
}
