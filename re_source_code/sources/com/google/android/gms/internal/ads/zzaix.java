package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaix implements Parcelable.Creator<zzaiw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiw createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        Bundle bundleF = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bundleF = SafeParcelReader.f(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzaiw(strP, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiw[] newArray(int i2) {
        return new zzaiw[i2];
    }
}
