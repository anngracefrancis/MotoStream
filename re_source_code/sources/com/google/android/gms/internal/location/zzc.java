package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class zzc {
    private static final ClassLoader a = zzc.class.getClassLoader();

    private zzc() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void c(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
