package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzarj implements Parcelable.Creator<zzari> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzari createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        long jG2 = 0;
        long jG3 = 0;
        long jG4 = 0;
        String strP = null;
        String strP2 = null;
        ArrayList<String> arrayListR = null;
        ArrayList<String> arrayListR2 = null;
        ArrayList<String> arrayListR3 = null;
        String strP3 = null;
        String strP4 = null;
        String strP5 = null;
        String strP6 = null;
        zzaru zzaruVar = null;
        String strP7 = null;
        String strP8 = null;
        zzato zzatoVar = null;
        ArrayList<String> arrayListR4 = null;
        ArrayList<String> arrayListR5 = null;
        zzark zzarkVar = null;
        String strP9 = null;
        ArrayList<String> arrayListR6 = null;
        String strP10 = null;
        zzauy zzauyVar = null;
        String strP11 = null;
        Bundle bundleF = null;
        ArrayList<String> arrayListR7 = null;
        String strP12 = null;
        String strP13 = null;
        int iE = 0;
        int iE2 = 0;
        boolean zW = false;
        int iE3 = 0;
        boolean zW2 = false;
        boolean zW3 = false;
        boolean zW4 = false;
        boolean zW5 = false;
        boolean zW6 = false;
        boolean zW7 = false;
        boolean zW8 = false;
        boolean zW9 = false;
        boolean zW10 = false;
        boolean zW11 = false;
        boolean zW12 = false;
        boolean zW13 = false;
        boolean zW14 = false;
        boolean zW15 = false;
        int iE4 = 0;
        boolean zW16 = false;
        boolean zW17 = false;
        boolean zW18 = false;
        boolean zW19 = false;
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
                    arrayListR = SafeParcelReader.r(parcel, iC);
                    break;
                case 5:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 6:
                    arrayListR2 = SafeParcelReader.r(parcel, iC);
                    break;
                case 7:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 8:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    jG2 = SafeParcelReader.G(parcel, iC);
                    break;
                case 10:
                    arrayListR3 = SafeParcelReader.r(parcel, iC);
                    break;
                case 11:
                    jG3 = SafeParcelReader.G(parcel, iC);
                    break;
                case 12:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                case 13:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 14:
                    jG4 = SafeParcelReader.G(parcel, iC);
                    break;
                case 15:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
                case 18:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 19:
                    strP5 = SafeParcelReader.p(parcel, iC);
                    break;
                case 21:
                    strP6 = SafeParcelReader.p(parcel, iC);
                    break;
                case 22:
                    zW3 = SafeParcelReader.w(parcel, iC);
                    break;
                case 23:
                    zW4 = SafeParcelReader.w(parcel, iC);
                    break;
                case 24:
                    zW5 = SafeParcelReader.w(parcel, iC);
                    break;
                case 25:
                    zW6 = SafeParcelReader.w(parcel, iC);
                    break;
                case 26:
                    zW7 = SafeParcelReader.w(parcel, iC);
                    break;
                case 28:
                    zzaruVar = (zzaru) SafeParcelReader.o(parcel, iC, zzaru.CREATOR);
                    break;
                case 29:
                    strP7 = SafeParcelReader.p(parcel, iC);
                    break;
                case 30:
                    strP8 = SafeParcelReader.p(parcel, iC);
                    break;
                case 31:
                    zW8 = SafeParcelReader.w(parcel, iC);
                    break;
                case 32:
                    zW9 = SafeParcelReader.w(parcel, iC);
                    break;
                case 33:
                    zzatoVar = (zzato) SafeParcelReader.o(parcel, iC, zzato.CREATOR);
                    break;
                case 34:
                    arrayListR4 = SafeParcelReader.r(parcel, iC);
                    break;
                case 35:
                    arrayListR5 = SafeParcelReader.r(parcel, iC);
                    break;
                case 36:
                    zW10 = SafeParcelReader.w(parcel, iC);
                    break;
                case 37:
                    zzarkVar = (zzark) SafeParcelReader.o(parcel, iC, zzark.CREATOR);
                    break;
                case 38:
                    zW11 = SafeParcelReader.w(parcel, iC);
                    break;
                case 39:
                    strP9 = SafeParcelReader.p(parcel, iC);
                    break;
                case 40:
                    arrayListR6 = SafeParcelReader.r(parcel, iC);
                    break;
                case 42:
                    zW12 = SafeParcelReader.w(parcel, iC);
                    break;
                case 43:
                    strP10 = SafeParcelReader.p(parcel, iC);
                    break;
                case 44:
                    zzauyVar = (zzauy) SafeParcelReader.o(parcel, iC, zzauy.CREATOR);
                    break;
                case 45:
                    strP11 = SafeParcelReader.p(parcel, iC);
                    break;
                case 46:
                    zW13 = SafeParcelReader.w(parcel, iC);
                    break;
                case 47:
                    zW14 = SafeParcelReader.w(parcel, iC);
                    break;
                case 48:
                    bundleF = SafeParcelReader.f(parcel, iC);
                    break;
                case 49:
                    zW15 = SafeParcelReader.w(parcel, iC);
                    break;
                case 50:
                    iE4 = SafeParcelReader.E(parcel, iC);
                    break;
                case 51:
                    zW16 = SafeParcelReader.w(parcel, iC);
                    break;
                case 52:
                    arrayListR7 = SafeParcelReader.r(parcel, iC);
                    break;
                case 53:
                    zW17 = SafeParcelReader.w(parcel, iC);
                    break;
                case 54:
                    strP12 = SafeParcelReader.p(parcel, iC);
                    break;
                case 55:
                    strP13 = SafeParcelReader.p(parcel, iC);
                    break;
                case 56:
                    zW18 = SafeParcelReader.w(parcel, iC);
                    break;
                case 57:
                    zW19 = SafeParcelReader.w(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzari(iE, strP, strP2, arrayListR, iE2, arrayListR2, jG, zW, jG2, arrayListR3, jG3, iE3, strP3, jG4, strP4, zW2, strP5, strP6, zW3, zW4, zW5, zW6, zW7, zzaruVar, strP7, strP8, zW8, zW9, zzatoVar, arrayListR4, arrayListR5, zW10, zzarkVar, zW11, strP9, arrayListR6, zW12, strP10, zzauyVar, strP11, zW13, zW14, bundleF, zW15, iE4, zW16, arrayListR7, zW17, strP12, strP13, zW18, zW19);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzari[] newArray(int i2) {
        return new zzari[i2];
    }
}
