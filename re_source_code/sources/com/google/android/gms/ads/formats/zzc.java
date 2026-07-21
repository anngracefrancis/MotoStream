package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<PublisherAdViewOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        IBinder iBinderD = null;
        IBinder iBinderD2 = null;
        boolean zW = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            int iV = SafeParcelReader.v(iC);
            if (iV == 1) {
                zW = SafeParcelReader.w(parcel, iC);
            } else if (iV == 2) {
                iBinderD = SafeParcelReader.D(parcel, iC);
            } else if (iV != 3) {
                SafeParcelReader.K(parcel, iC);
            } else {
                iBinderD2 = SafeParcelReader.D(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new PublisherAdViewOptions(zW, iBinderD, iBinderD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions[] newArray(int i2) {
        return new PublisherAdViewOptions[i2];
    }
}
