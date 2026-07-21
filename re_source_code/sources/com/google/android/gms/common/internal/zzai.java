package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        int iE = 0;
        boolean zW = false;
        boolean zW2 = false;
        int iE2 = 0;
        int iE3 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV == 2) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 3) {
                zW2 = SafeParcelReader.w(parcel, iC);
            } else if (iV == 4) {
                iE2 = SafeParcelReader.E(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iE3 = SafeParcelReader.E(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new RootTelemetryConfiguration(iE, zW, zW2, iE2, iE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new RootTelemetryConfiguration[i2];
    }
}
