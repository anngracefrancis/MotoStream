package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzq implements Parcelable.Creator<GeofencingRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        ArrayList arrayListT = null;
        int iE = 0;
        String strP = HttpUrl.FRAGMENT_ENCODE_SET;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                arrayListT = SafeParcelReader.t(parcel, iC, zzbh.CREATOR);
            } else if (iV == 2) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new GeofencingRequest(arrayListT, iE, strP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest[] newArray(int i2) {
        return new GeofencingRequest[i2];
    }
}
