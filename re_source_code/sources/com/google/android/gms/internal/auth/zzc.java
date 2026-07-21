package com.google.android.gms.internal.auth;

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

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
