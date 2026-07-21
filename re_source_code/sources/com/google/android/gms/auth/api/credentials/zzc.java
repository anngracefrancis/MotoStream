package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        String strP = null;
        String strP2 = null;
        Uri uri = null;
        ArrayList arrayListT = null;
        String strP3 = null;
        String strP4 = null;
        String strP5 = null;
        String strP6 = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 2:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.o(parcel, iC, Uri.CREATOR);
                    break;
                case 4:
                    arrayListT = SafeParcelReader.t(parcel, iC, IdToken.CREATOR);
                    break;
                case 5:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 6:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 7:
                case 8:
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
                case 9:
                    strP5 = SafeParcelReader.p(parcel, iC);
                    break;
                case 10:
                    strP6 = SafeParcelReader.p(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new Credential(strP, strP2, uri, arrayListT, strP3, strP4, strP5, strP6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i2) {
        return new Credential[i2];
    }
}
