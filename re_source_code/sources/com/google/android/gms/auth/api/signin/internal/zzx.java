package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzx implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                googleSignInOptions = (GoogleSignInOptions) SafeParcelReader.o(parcel, iC, GoogleSignInOptions.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new SignInConfiguration(strP, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i2) {
        return new SignInConfiguration[i2];
    }
}
