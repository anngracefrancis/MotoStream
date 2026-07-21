package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
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

    public static void b(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static boolean c(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
