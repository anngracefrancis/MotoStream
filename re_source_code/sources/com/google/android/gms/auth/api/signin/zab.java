package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zab implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        String strP3 = null;
        String strP4 = null;
        Uri uri = null;
        String strP5 = null;
        String strP6 = null;
        ArrayList arrayListT = null;
        String strP7 = null;
        String strP8 = null;
        long jG = 0;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 3:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 4:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.o(parcel, iC, Uri.CREATOR);
                    break;
                case 7:
                    strP5 = SafeParcelReader.p(parcel, iC);
                    break;
                case 8:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 9:
                    strP6 = SafeParcelReader.p(parcel, iC);
                    break;
                case 10:
                    arrayListT = SafeParcelReader.t(parcel, iC, Scope.CREATOR);
                    break;
                case 11:
                    strP7 = SafeParcelReader.p(parcel, iC);
                    break;
                case 12:
                    strP8 = SafeParcelReader.p(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new GoogleSignInAccount(iE, strP, strP2, strP3, strP4, uri, strP5, jG, strP6, arrayListT, strP7, strP8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
