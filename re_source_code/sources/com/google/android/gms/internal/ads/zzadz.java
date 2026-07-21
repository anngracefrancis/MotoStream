package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzadz implements Parcelable.Creator<zzady> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzady createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        zzacd zzacdVar = null;
        int iE = 0;
        boolean zW = false;
        int iE2 = 0;
        boolean zW2 = false;
        int iE3 = 0;
        boolean zW3 = false;
        int iE4 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 3:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 4:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 5:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                case 6:
                    zzacdVar = (zzacd) SafeParcelReader.o(parcel, iC, zzacd.CREATOR);
                    break;
                case 7:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 8:
                    iE4 = SafeParcelReader.E(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzady(iE, zW, iE2, zW2, iE3, zzacdVar, zW3, iE4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzady[] newArray(int i2) {
        return new zzady[i2];
    }
}
