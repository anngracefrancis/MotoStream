package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = HttpUrl.FRAGMENT_ENCODE_SET;
        GoogleSignInAccount googleSignInAccount = null;
        String strP2 = HttpUrl.FRAGMENT_ENCODE_SET;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 4) {
                strP = SafeParcelReader.p(parcel, iC);
            } else if (iV == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.o(parcel, iC, GoogleSignInAccount.CREATOR);
            } else if (iV != 8) {
                SafeParcelReader.K(parcel, iC);
            } else {
                strP2 = SafeParcelReader.p(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new SignInAccount(strP, googleSignInAccount, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i2) {
        return new SignInAccount[i2];
    }
}
