package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbg implements Parcelable.Creator<zzbf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbf createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        zzbd zzbdVar = null;
        IBinder iBinderD = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderD2 = null;
        IBinder iBinderD3 = null;
        int iE = 1;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    zzbdVar = (zzbd) SafeParcelReader.o(parcel, iC, zzbd.CREATOR);
                    break;
                case 3:
                    iBinderD = SafeParcelReader.D(parcel, iC);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, iC, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderD2 = SafeParcelReader.D(parcel, iC);
                    break;
                case 6:
                    iBinderD3 = SafeParcelReader.D(parcel, iC);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new zzbf(iE, zzbdVar, iBinderD, pendingIntent, iBinderD2, iBinderD3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbf[] newArray(int i2) {
        return new zzbf[i2];
    }
}
