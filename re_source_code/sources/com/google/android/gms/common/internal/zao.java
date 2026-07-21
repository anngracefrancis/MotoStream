package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zao implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        Scope[] scopeArr = null;
        int iE2 = 0;
        int iE3 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                iE2 = SafeParcelReader.E(parcel, iC);
            } else if (iV == 3) {
                iE3 = SafeParcelReader.E(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.s(parcel, iC, Scope.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new SignInButtonConfig(iE, iE2, iE3, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }
}
