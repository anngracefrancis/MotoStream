package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzyb implements Parcelable.Creator<zzxz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Bundle bundleF = null;
        ArrayList<String> arrayListR = null;
        String strP = null;
        zzaca zzacaVar = null;
        Location location = null;
        String strP2 = null;
        Bundle bundleF2 = null;
        Bundle bundleF3 = null;
        ArrayList<String> arrayListR2 = null;
        String strP3 = null;
        String strP4 = null;
        zzxt zzxtVar = null;
        String strP5 = null;
        long jG = 0;
        int iE = 0;
        int iE2 = 0;
        boolean zW = false;
        int iE3 = 0;
        boolean zW2 = false;
        boolean zW3 = false;
        int iE4 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 3:
                    bundleF = SafeParcelReader.f(parcel, iC);
                    break;
                case 4:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 5:
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 6:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 7:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                case 8:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 10:
                    zzacaVar = (zzaca) SafeParcelReader.o(parcel, iC, zzaca.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.o(parcel, iC, Location.CREATOR);
                    break;
                case 12:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 13:
                    bundleF2 = SafeParcelReader.f(parcel, iC);
                    break;
                case 14:
                    bundleF3 = SafeParcelReader.f(parcel, iC);
                    break;
                case 15:
                    arrayListR2 = SafeParcelReader.r(parcel, iC);
                    break;
                case 16:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 17:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 18:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 19:
                    zzxtVar = (zzxt) SafeParcelReader.o(parcel, iC, zzxt.CREATOR);
                    break;
                case 20:
                    iE4 = SafeParcelReader.E(parcel, iC);
                    break;
                case 21:
                    strP5 = SafeParcelReader.p(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzxz(iE, jG, bundleF, iE2, arrayListR, zW, iE3, zW2, strP, zzacaVar, location, strP2, bundleF2, bundleF3, arrayListR2, strP3, strP4, zW3, zzxtVar, iE4, strP5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz[] newArray(int i2) {
        return new zzxz[i2];
    }
}
