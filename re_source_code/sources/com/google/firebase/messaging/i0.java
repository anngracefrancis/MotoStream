package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class i0 implements Parcelable.Creator<RemoteMessage> {
    static void c(RemoteMessage remoteMessage, Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.e(parcel, 2, remoteMessage.f19778f, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(iC) != 2) {
                SafeParcelReader.K(parcel, iC);
            } else {
                bundleF = SafeParcelReader.f(parcel, iC);
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new RemoteMessage(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
