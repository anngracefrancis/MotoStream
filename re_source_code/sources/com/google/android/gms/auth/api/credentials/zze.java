package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zze implements Parcelable.Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        int iE2 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 2) {
                zW2 = SafeParcelReader.w(parcel, iC);
            } else if (iV == 3) {
                zW3 = SafeParcelReader.w(parcel, iC);
            } else if (iV == 4) {
                iE2 = SafeParcelReader.E(parcel, iC);
            } else if (iV != 1000) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new CredentialPickerConfig(iE, zW, zW2, zW3, iE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i2) {
        return new CredentialPickerConfig[i2];
    }
}
