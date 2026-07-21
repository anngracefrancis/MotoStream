package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzary implements Parcelable.Creator<zzarx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarx createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Bundle bundleF = null;
        zzbai zzbaiVar = null;
        ApplicationInfo applicationInfo = null;
        String strP = null;
        ArrayList<String> arrayListR = null;
        PackageInfo packageInfo = null;
        String strP2 = null;
        String strP3 = null;
        boolean zW = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    bundleF = SafeParcelReader.f(parcel, iC);
                    break;
                case 2:
                    zzbaiVar = (zzbai) SafeParcelReader.o(parcel, iC, zzbai.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.o(parcel, iC, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.o(parcel, iC, PackageInfo.CREATOR);
                    break;
                case 7:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 8:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzarx(bundleF, zzbaiVar, applicationInfo, strP, arrayListR, packageInfo, strP2, zW, strP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarx[] newArray(int i2) {
        return new zzarx[i2];
    }
}
