package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrJ = null;
        int[] iArrJ2 = null;
        boolean zW = false;
        boolean zW2 = false;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.o(parcel, iC, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 3:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 4:
                    iArrJ = SafeParcelReader.j(parcel, iC);
                    break;
                case 5:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 6:
                    iArrJ2 = SafeParcelReader.j(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zW, zW2, iArrJ, iE, iArrJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ConnectionTelemetryConfiguration[i2];
    }
}
