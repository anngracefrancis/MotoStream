package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzy implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        long jG2 = 0;
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        Bundle bundleF = null;
        boolean zW = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 2:
                    jG2 = SafeParcelReader.G(parcel, iC);
                    break;
                case 3:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 4:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 6:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 7:
                    bundleF = SafeParcelReader.f(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzv(jG, jG2, zW, strP, strP2, strP3, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i2) {
        return new zzv[i2];
    }
}
