package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzauz implements Parcelable.Creator<zzauy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauy createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        ArrayList<String> arrayListR = null;
        ArrayList<String> arrayListR2 = null;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        boolean zW4 = false;
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
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 5:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 6:
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 7:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 8:
                    zW4 = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    arrayListR2 = SafeParcelReader.r(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzauy(strP, strP2, zW, zW2, arrayListR, zW3, zW4, arrayListR2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauy[] newArray(int i2) {
        return new zzauy[i2];
    }
}
