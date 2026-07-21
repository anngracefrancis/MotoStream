package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzbai;

/* JADX INFO: loaded from: classes2.dex */
public final class zzn implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        zzc zzcVar = null;
        IBinder iBinderD = null;
        IBinder iBinderD2 = null;
        IBinder iBinderD3 = null;
        IBinder iBinderD4 = null;
        String strP = null;
        String strP2 = null;
        IBinder iBinderD5 = null;
        String strP3 = null;
        zzbai zzbaiVar = null;
        String strP4 = null;
        com.google.android.gms.ads.internal.zzh zzhVar = null;
        IBinder iBinderD6 = null;
        boolean zW = false;
        int iE = 0;
        int iE2 = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.o(parcel, iC, zzc.CREATOR);
                    break;
                case 3:
                    iBinderD = SafeParcelReader.D(parcel, iC);
                    break;
                case 4:
                    iBinderD2 = SafeParcelReader.D(parcel, iC);
                    break;
                case 5:
                    iBinderD3 = SafeParcelReader.D(parcel, iC);
                    break;
                case 6:
                    iBinderD4 = SafeParcelReader.D(parcel, iC);
                    break;
                case 7:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 8:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 9:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 10:
                    iBinderD5 = SafeParcelReader.D(parcel, iC);
                    break;
                case 11:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 12:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 13:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 14:
                    zzbaiVar = (zzbai) SafeParcelReader.o(parcel, iC, zzbai.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
                case 16:
                    strP4 = SafeParcelReader.p(parcel, iC);
                    break;
                case 17:
                    zzhVar = (com.google.android.gms.ads.internal.zzh) SafeParcelReader.o(parcel, iC, com.google.android.gms.ads.internal.zzh.CREATOR);
                    break;
                case 18:
                    iBinderD6 = SafeParcelReader.D(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new AdOverlayInfoParcel(zzcVar, iBinderD, iBinderD2, iBinderD3, iBinderD4, strP, zW, strP2, iBinderD5, iE, iE2, strP3, zzbaiVar, strP4, zzhVar, iBinderD6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i2) {
        return new AdOverlayInfoParcel[i2];
    }
}
