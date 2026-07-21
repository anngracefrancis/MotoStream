package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<AccountChangeEventsResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsResponse createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        ArrayList arrayListT = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                arrayListT = SafeParcelReader.t(parcel, iC, AccountChangeEvent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new AccountChangeEventsResponse(iE, arrayListT);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsResponse[] newArray(int i2) {
        return new AccountChangeEventsResponse[i2];
    }
}
