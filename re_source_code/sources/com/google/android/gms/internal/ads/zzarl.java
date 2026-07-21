package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzarl implements Parcelable.Creator<zzark> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzark createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        boolean zW = false;
        ArrayList<String> arrayListR = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 2) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                arrayListR = SafeParcelReader.r(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzark(zW, arrayListR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzark[] newArray(int i2) {
        return new zzark[i2];
    }
}
