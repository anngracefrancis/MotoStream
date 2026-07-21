package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzarw implements Parcelable.Creator<zzaru> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaru createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.o(parcel, iC, ParcelFileDescriptor.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaru(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaru[] newArray(int i2) {
        return new zzaru[i2];
    }
}
