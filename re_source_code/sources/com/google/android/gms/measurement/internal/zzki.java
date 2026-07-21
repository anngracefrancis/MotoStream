package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzki implements Parcelable.Creator<zzkj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkj createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        Long lH = null;
        Float fB = null;
        String strP2 = null;
        String strP3 = null;
        Double dZ = null;
        long jG = 0;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 3:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 4:
                    lH = SafeParcelReader.H(parcel, iC);
                    break;
                case 5:
                    fB = SafeParcelReader.B(parcel, iC);
                    break;
                case 6:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 7:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 8:
                    dZ = SafeParcelReader.z(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzkj(iE, strP, jG, lH, fB, strP2, strP3, dZ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkj[] newArray(int i2) {
        return new zzkj[i2];
    }
}
