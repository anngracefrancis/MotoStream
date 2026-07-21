package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzk implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Bundle bundleF = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                bundleF = SafeParcelReader.f(parcel, iC);
            } else if (iV == 2) {
                featureArr = (Feature[]) SafeParcelReader.s(parcel, iC, Feature.CREATOR);
            } else if (iV == 3) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 4) {
                SafeParcelReader.K(parcel, iC);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.o(parcel, iC, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzj(bundleF, featureArr, iE, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }
}
