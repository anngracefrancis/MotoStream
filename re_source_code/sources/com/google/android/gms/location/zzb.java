package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        long jG2 = 0;
        ArrayList arrayListT = null;
        Bundle bundleF = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                arrayListT = SafeParcelReader.t(parcel, iC, DetectedActivity.CREATOR);
            } else if (iV == 2) {
                jG = SafeParcelReader.G(parcel, iC);
            } else if (iV == 3) {
                jG2 = SafeParcelReader.G(parcel, iC);
            } else if (iV == 4) {
                iE = SafeParcelReader.E(parcel, iC);
            } else if (iV != 5) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bundleF = SafeParcelReader.f(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new ActivityRecognitionResult(arrayListT, jG, jG2, iE, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i2) {
        return new ActivityRecognitionResult[i2];
    }
}
