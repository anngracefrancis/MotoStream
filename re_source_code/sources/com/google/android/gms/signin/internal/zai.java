package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zai implements Parcelable.Creator<zah> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zah createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) SafeParcelReader.o(parcel, iC, ResolveAccountRequest.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zah(iE, resolveAccountRequest);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zah[] newArray(int i2) {
        return new zah[i2];
    }
}
