package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: classes2.dex */
public final class zai implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        zaa zaaVar = null;
        int iE = 0;
        int iE2 = 0;
        boolean zW = false;
        int iE3 = 0;
        boolean zW2 = false;
        int iE4 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 3:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 4:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                case 5:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 6:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 7:
                    iE4 = SafeParcelReader.E(parcel, iC);
                    break;
                case 8:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.o(parcel, iC, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new FastJsonResponse.Field(iE, iE2, zW, iE3, zW2, strP, iE4, strP2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
