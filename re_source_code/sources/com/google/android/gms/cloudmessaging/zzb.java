package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<CloudMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 1) {
                SafeParcelReader.K(parcel, iC);
            } else {
                intent = (Intent) SafeParcelReader.o(parcel, iC, Intent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new CloudMessage(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage[] newArray(int i2) {
        return new CloudMessage[i2];
    }
}
