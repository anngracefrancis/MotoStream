package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class zzj implements Parcelable.Creator<SafeBrowsingData> {
    static void a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, safeBrowsingData.Y(), false);
        SafeParcelWriter.s(parcel, 3, safeBrowsingData.y(), i2, false);
        SafeParcelWriter.s(parcel, 4, safeBrowsingData.z(), i2, false);
        SafeParcelWriter.p(parcel, 5, safeBrowsingData.W());
        SafeParcelWriter.f(parcel, 6, safeBrowsingData.e0(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArrG = null;
        long jG = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 3) {
                dataHolder = (DataHolder) SafeParcelReader.o(parcel, iC, DataHolder.CREATOR);
            } else if (iV == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.o(parcel, iC, ParcelFileDescriptor.CREATOR);
            } else if (iV == 5) {
                jG = SafeParcelReader.G(parcel, iC);
            } else if (iV != 6) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bArrG = SafeParcelReader.g(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new SafeBrowsingData(strP, dataHolder, parcelFileDescriptor, jG, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i2) {
        return new SafeBrowsingData[i2];
    }
}
