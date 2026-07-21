package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzu implements Parcelable.Creator<zzt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        String strP = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int iE = 0;
        int iE2 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    hashSet.add(1);
                    break;
                case 2:
                    strP = SafeParcelReader.p(parcel, iC);
                    hashSet.add(2);
                    break;
                case 3:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iC);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, iC, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) SafeParcelReader.o(parcel, iC, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        if (parcel.dataPosition() == iL) {
            return new zzt(hashSet, iE, strP, iE2, bArrG, pendingIntent, deviceMetaData);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(iL);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i2) {
        return new zzt[i2];
    }
}
