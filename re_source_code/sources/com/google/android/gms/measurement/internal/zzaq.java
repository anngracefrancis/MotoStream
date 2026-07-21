package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaq implements Parcelable.Creator<zzan> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzan createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        zzam zzamVar = null;
        String strP2 = null;
        long jG = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 3) {
                zzamVar = (zzam) SafeParcelReader.o(parcel, iC, zzam.CREATOR);
            } else if (iV == 4) {
                strP2 = SafeParcelReader.p(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                jG = SafeParcelReader.G(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzan(strP, zzamVar, strP2, jG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzan[] newArray(int i2) {
        return new zzan[i2];
    }
}
