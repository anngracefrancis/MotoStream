package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzam implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ArrayList<String> arrayListR = null;
        String strP = HttpUrl.FRAGMENT_ENCODE_SET;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                arrayListR = SafeParcelReader.r(parcel, iC);
            } else if (iV == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, iC, PendingIntent.CREATOR);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzal(arrayListR, pendingIntent, strP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i2) {
        return new zzal[i2];
    }
}
