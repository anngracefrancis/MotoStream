package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzy implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        long jG = 0;
        long jG2 = 0;
        long jG3 = 0;
        String strP = null;
        String strP2 = null;
        zzkj zzkjVar = null;
        String strP3 = null;
        zzan zzanVar = null;
        zzan zzanVar2 = null;
        zzan zzanVar3 = null;
        boolean zW = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 2:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 3:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
                case 4:
                    zzkjVar = (zzkj) SafeParcelReader.o(parcel, iC, zzkj.CREATOR);
                    break;
                case 5:
                    jG = SafeParcelReader.G(parcel, iC);
                    break;
                case 6:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 7:
                    strP3 = SafeParcelReader.p(parcel, iC);
                    break;
                case 8:
                    zzanVar = (zzan) SafeParcelReader.o(parcel, iC, zzan.CREATOR);
                    break;
                case 9:
                    jG2 = SafeParcelReader.G(parcel, iC);
                    break;
                case 10:
                    zzanVar2 = (zzan) SafeParcelReader.o(parcel, iC, zzan.CREATOR);
                    break;
                case 11:
                    jG3 = SafeParcelReader.G(parcel, iC);
                    break;
                case 12:
                    zzanVar3 = (zzan) SafeParcelReader.o(parcel, iC, zzan.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzv(strP, strP2, zzkjVar, jG, zW, strP3, zzanVar, jG2, zzanVar2, jG3, zzanVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i2) {
        return new zzv[i2];
    }
}
