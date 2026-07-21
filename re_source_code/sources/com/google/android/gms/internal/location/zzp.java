package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzp implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        zzm zzmVar = null;
        IBinder iBinderD = null;
        IBinder iBinderD2 = null;
        int iE = 1;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                zzmVar = (zzm) SafeParcelReader.o(parcel, iC, zzm.CREATOR);
            } else if (iV == 3) {
                iBinderD = SafeParcelReader.D(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iBinderD2 = SafeParcelReader.D(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzo(iE, zzmVar, iBinderD, iBinderD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i2) {
        return new zzo[i2];
    }
}
