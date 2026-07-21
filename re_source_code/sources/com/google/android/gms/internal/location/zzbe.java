package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbe implements Parcelable.Creator<zzbd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        List<ClientIdentity> listT = zzbd.f17093f;
        LocationRequest locationRequest = null;
        String strP = null;
        String strP2 = null;
        boolean zW = false;
        boolean zW2 = false;
        boolean zW3 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV != 1) {
                switch (iV) {
                    case 5:
                        listT = SafeParcelReader.t(parcel, iC, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        strP = SafeParcelReader.p(parcel, iC);
                        break;
                    case 7:
                        zW = SafeParcelReader.w(parcel, iC);
                        break;
                    case 8:
                        zW2 = SafeParcelReader.w(parcel, iC);
                        break;
                    case 9:
                        zW3 = SafeParcelReader.w(parcel, iC);
                        break;
                    case 10:
                        strP2 = SafeParcelReader.p(parcel, iC);
                        break;
                    default:
                        SafeParcelReader.K(parcel, iC);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.o(parcel, iC, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzbd(locationRequest, listT, strP, zW, zW2, zW3, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd[] newArray(int i2) {
        return new zzbd[i2];
    }
}
