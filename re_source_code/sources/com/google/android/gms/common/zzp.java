package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        IBinder iBinderD = null;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 2) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 3) {
                zW2 = SafeParcelReader.w(parcel, iC);
            } else if (iV == 4) {
                iBinderD = SafeParcelReader.D(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                zW3 = SafeParcelReader.w(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzo(strP, zW, zW2, iBinderD, zW3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzo[i2];
    }
}
